// 1. 原型对象概述
// 1.1 构造函数的缺点
function Cat(name, color) {
    this.name = name;
    this.color = color;
}

var cat1 = new Cat('大毛', '白色');

cat1.name // '大毛'
cat1.color // '白色'

// 同一个构造函数的多个实例之间，无法共享属性，从而造成对系统资源的浪费。
function Cat(name, color) {
    this.name = name;
    this.color = color;
    this.meow = function () {
        console.log('喵喵');
    };
}

var cat1 = new Cat('大毛', '白色');
var cat2 = new Cat('二毛', '黑色');

cat1.meow === cat2.meow // false

// 这个问题的解决方法，就是 JavaScript 的原型对象（prototype）。
// 1.2 prototype 属性的作用
// JavaScript 规定，每个函数都有一个prototype属性，指向一个对象。
function f() {
}

typeof f.prototype // "object"

// 对于普通函数来说，该属性基本无用。但是，对于构造函数来说，生成实例的时候，该属性会自动成为实例对象的原型。
function Animal(name) {
    this.name = name;
}

Animal.prototype.color = 'white';

var cat1 = new Animal('大毛');
var cat2 = new Animal('二毛');

cat1.color // 'white'
cat2.color // 'white'

// 原型对象的属性不是实例对象自身的属性。只要修改原型对象，变动就立刻会体现在所有实例对象上。
Animal.prototype.color = 'yellow';

cat1.color // "yellow"
cat2.color // "yellow"

// 如果实例对象自身就有某个属性或方法，它就不会再去原型对象寻找这个属性或方法。
cat1.color = 'black';

cat1.color // 'black'
cat2.color // 'yellow'
Animal.prototype.color // 'yellow';

// 原型对象的作用，就是定义所有实例对象共享的属性和方法。这也是它被称为原型对象的原因，而实例对象可以视作从原型对象衍生出来的子对象。
Animal.prototype.walk = function () {
    console.log(this.name + ' is walking');
};


// 1.3 原型链
// Object.prototype的原型是null。null没有任何属性和方法，也没有自己的原型。因此，原型链的尽头就是null。
Object.getPrototypeOf(Object.prototype) // null

// 如果让构造函数的prototype属性指向一个数组，就意味着实例对象可以调用数组方法。
var MyArray = function () {
}

MyArray.prototype = new Array()
MyArray.prototype.constructor = MyArray

var mine = new MyArray()
mine.push(1, 2, 3)
mine.length // 3
mine instanceof Array // true


// 1.4 constructor 属性
// prototype对象有一个constructor属性，默认指向prototype对象所在的构造函数。
function P() {
}

P.prototype.constructor === P // true


// p是构造函数P的实例对象，但是p自身没有constructor属性，该属性其实是读取原型链上面的P.prototype.constructor属性。
function P() {
}

var p = new P()

p.constructor === P // true
p.constructor === P.prototype.constructor // true
p.hasOwnProperty('constructor') // false


// constructor属性确定了实例对象f的构造函数是F，而不是RegExp
function F() {
}

var f = new F()

f.constructor === F // true
f.constructor === RegExp // false


// x是构造函数Constr的实例，可以从x.constructor间接调用构造函数。这使得在实例方法中，调用自身的构造函数成为可能。
function Constr() {
}

var x = new Constr()

var y = new x.constructor()
y instanceof Constr // true


// createCopy方法调用构造函数，新建另一个实例
Constr.prototype.createCopy = function () {
    return new this.constructor()
}


// 构造函数Person的原型对象改掉了，但是没有修改constructor属性，导致这个属性不再指向Person。
// 由于Person的新原型是一个普通对象，而普通对象的constructor属性指向Object构造函数，导致Person.prototype.constructor变成了Object
function Person(name) {
    this.name = name
}

Person.prototype.constructor === Person // true

Person.prototype = {
    method: function () {
    }
}

Person.prototype.constructor === Person // false
Person.prototype.constructor === Object // true


// 如果不能确定constructor属性是什么函数，还有一个办法：通过name属性，从实例得到构造函数的名称。
function Foo() {
}

var f = new Foo()
f.constructor.name // "Foo"


// 2.instanceof 运算符
// instanceof运算符返回一个布尔值，表示对象是否为某个构造函数的实例。

// 对象v是构造函数Vehicle的实例，所以返回true
var v = new Vehicle();
v instanceof Vehicle // true

// Vehicle是对象v的构造函数，它的原型对象是Vehicle.prototype，
// isPrototypeOf()方法是 JavaScript 提供的原生方法，用于检查某个对象是否为另一个对象的原型
v instanceof Vehicle
// 等同于
Vehicle.prototype.isPrototypeOf(v)

// d同时是Date和Object的实例，因此对这两个构造函数都返回true
var d = new Date();
d instanceof Date // true
d instanceof Object // true

// 除了null，其他对象的instanceOf Object的运算结果都是true。
var obj = {foo: 123};
obj instanceof Object // true
null instanceof Object // false

// Object.create(null)返回一个新对象obj，它的原型是null（Object.create()的详细介绍见后文）。
// 右边的构造函数Object的prototype属性，不在左边的原型链上，因此instanceof就认为obj不是Object的实例。
// 这是唯一的instanceof运算符判断会失真的情况（一个对象的原型是null）
var obj = Object.create(null);
typeof obj // "object"
obj instanceof Object // false

// instanceof运算符判断，变量x是数组，变量y是对象
var x = [1, 2, 3];
var y = {};
x instanceof Array // true
y instanceof Object // true

// instanceof运算符只能用于对象，不适用原始类型的值
var s = 'hello';
s instanceof String // false

// 对于undefined和null，instanceof运算符总是返回false
undefined instanceof Object // false
null instanceof Object // false

// 在函数体内部判断this关键字是否为构造函数Fubar的实例。如果不是，就表明忘了加new命令
function Fubar(foo, bar) {
    if (this instanceof Fubar) {
        this._foo = foo;
        this._bar = bar;
    } else {
        return new Fubar(foo, bar);
    }
}


// 3. 构造函数的继承
// Sub是子类的构造函数，this是子类的实例。在实例上调用父类的构造函数Super，就会让子类实例具有父类实例的属性
function Sub(value) {
    Super.call(this);
    this.prop = value;
}

// Sub.prototype是子类的原型，要将它赋值为Object.create(Super.prototype)，
// 而不是直接等于Super.prototype。否则后面两行对Sub.prototype的操作，会连父类的原型Super.prototype一起修改掉
Sub.prototype = Object.create(Super.prototype);
Sub.prototype.constructor = Sub;
Sub.prototype.method = '...';
