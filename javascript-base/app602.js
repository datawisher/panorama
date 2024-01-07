/**
 * this 关键字
 */
var A = {
    name: '张三',
    describe: function () {
        return '姓名：' + this.name;
    }
};

var B = {
    name: '李四'
};

B.describe = A.describe;
console.log(B.describe()); // "姓名：李四"
// this的指向是可变的

console.log("##########");
var A = {
    name: '刘备',
    describe: function () {
        return '姓名：' + this.name;
    }
};

var name = '张飞';
var f = A.describe;
console.log(f());


console.log("##########");
var f = function () {
    console.log(this.x);
}

var x = 1;
var obj = {
    f: f,
    x: 2,
};

// 单独执行
f() // undefined

// obj 环境执行
obj.f() // 2


/**
 * 避免多层 this
 */
var o = {
    f1: function () {
        console.log(this);
        var that = this;
        var f2 = function () {
            console.log(that);
        }();
    }
}

o.f1()
// Object
// Object


/**
 * 避免数组处理方法中的 this
 */
var o = {
    v: 'hello',
    p: ['a1', 'a2'],
    f: function f() {
        var that = this;
        this.p.forEach(function (item) {
            console.log(that.v + ' ' + item);
        });
    }
}

o.f()
// hello a1 
// hello a2


/**
 * 避免回调函数中的 this
 * 回调函数中的this往往会改变指向，最好避免使用。
 */
var o = new Object();
o.f = function () {
    console.log(this === o);
}

// jQuery 的写法, 结果是false
// $('#button').on('click', o.f);

/**
 * 绑定 this 的方法
 */
// Function.prototype.call()
var obj = {};

var f = function () {
    return this;
};

f() === global // true
f.call(obj) === obj // true
//call方法可以改变this的指向
//call方法的参数，应该是一个对象。如果参数为空、null和undefined，则默认传入全局对象。

var f = function () {
    return this;
};

f.call(5) // [Number: 5]

//call方法还可以接受多个参数。func.call(thisValue, arg1, arg2, ...)
function add(a, b) {
    return a + b;
}

add.call(this, 1, 2) // 3


var obj = {};
obj.hasOwnProperty('toString') // false
// 覆盖掉继承的 hasOwnProperty 方法
obj.hasOwnProperty = function () {
    return true;
};
obj.hasOwnProperty('toString') // true

Object.prototype.hasOwnProperty.call(obj, 'toString') // false


// Function.prototype.apply()
// 与call()的区别是，它接收一个数组作为函数执行时的参数。func.apply(thisValue, [arg1, arg2, ...])
function f(x, y) {
    console.log(x + y);
}

f.call(null, 1, 1) // 2
f.apply(null, [1, 1]) // 2

// 对象转数组。被处理的对象必须有length属性
Array.prototype.slice.apply({ 0: 1, length: 1 }) // [1]
Array.prototype.slice.apply({ 0: 1 }) // []
Array.prototype.slice.apply({ 0: 1, length: 2 }) // [1, undefined]
Array.prototype.slice.apply({ length: 1 }) // [undefined]


// 之前的例子，结果是true
var o = new Object();

o.f = function () {
    console.log(this === o);
}

var f = function () {
    o.f.apply(o);
    // 或者 o.f.call(o);
};

// jQuery 的写法
// $('#button').on('click', f);

// 5.3 Function.prototype.bind()
var d = new Date()
d.getTime() // 1704118791125

// var print = d.getTime
// print()

var print = d.getTime.bind(d)
print() // 1704118791125

var counter = {
    count: 0,
    inc: function () {
        this.count++;
    }
};

var func = counter.inc.bind(counter);
func();
counter.count // 1


// this 绑定到其它对象
var counter = {
    count: 0,
    inc: function () {
        this.count++;
    }
};

var obj = {
    count: 100
};
var func = counter.inc.bind(obj);
func();
obj.count // 101


// bind()还可以接受更多的参数，将这些参数绑定原函数的参数
var add = function (x, y) {
    return x * this.m + y * this.n;
}

var obj = {
    m: 2,
    n: 2
};

var newAdd = add.bind(obj, 5);
newAdd(5) // 20


// 如果bind()方法的第一个参数是null或undefined，等于将this绑定到全局对象，函数运行时this指向顶层对象（浏览器为window）
function add(x, y) {
    return x + y;
}

var plus5 = add.bind(null, 5);
plus5(10) // 15


// 利用call()方法，可以改写一些 JavaScript 原生方法的使用形式，以数组的slice()方法为例。
[1, 2, 3].slice(0, 1) // [1]
// 等同于
Array.prototype.slice.call([1, 2, 3], 0, 1) // [1]
var slice = Function.prototype.call.bind(Array.prototype.slice);
slice([1, 2, 3], 0, 1) // [1]