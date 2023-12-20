/**
 * 实例对象与 new 命令
 */
var Vehicle = function () {
    this.price = 1000;
}
// 构造函数

var v = new Vehicle();
console.log(v.price); // 1000

var Vehicle = function (p) {
    this.price = p;
};

var v = new Vehicle(500);
console.log(v.price); // 500


var Vehicle = function () {
    this.price = 1000;
};

var v = Vehicle();
console.log(v) // undefined
console.log(price); // 1000


var Vehicle = function () {
    this.price = 1000;
    return 1000;
};
(new Vehicle()) === 1000
// false, 数值，new命令就会忽略这个return语句，返回“构造”后的this对象。

var Vehicle = function () {
    this.price = 1000;
    return { price: 2000 };
};
(new Vehicle()).price
// 2000， 对象，new命令会返回这个对象，而不是this对象。


function getMessage() {
    return 'this is a message';
}

var msg = new getMessage();

msg // {} 如果对普通函数（内部没有this关键字的函数）使用new命令，则会返回一个空对象。
typeof msg // "object"


/**
 * new.target
 */
function f() {
    console.log(new.target === f);
}

f() // false
new f() // true

/**
 * Object.create() 创建实例对象
 */
var person1 = {
    name: '张三',
    age: 38,
    greeting: function () {
        console.log('Hi! I\'m ' + this.name + '.');
    }
};

var person2 = Object.create(person1);

// person2.name // 张三
// person2.greeting() // Hi! I'm 张三.
console.log(person1.name);
person1.greeting()