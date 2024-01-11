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
function f() { }
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