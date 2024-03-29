// 7.1 使用命名的函数表达式代替函数声明。eslint: func-style
// 为什么? 函数声明是挂起的，这意味着在它在文件中定义之前，很容易引用函数。这会损害可读性和可维护性。
// 如果您发现函数的定义是大的或复杂的，以至于它干扰了对文件的其余部分的理解，那么也许是时候将它提取到它自己的模块中了!
// 不要忘记显式地命名这个表达式，不管它的名称是否从包含变量(在现代浏览器中经常是这样，或者在使用诸如Babel之类的编译器时)。
// 这消除了对错误的调用堆栈的任何假设。

// bad
function foo() {
    // ...
}

// bad
const foo = function () {
    // ...
};

// good
// 从变量引用调用中区分的词汇名称
const short = function longUniqueMoreDescriptiveLexicalFoo() {
    // ...
};


// 7.2 Wrap立即调用函数表达式。 eslint: wrap-iife
// 为什么? 立即调用的函数表达式是单个单元 - 包装， 并且拥有括号调用, 在括号内, 清晰的表达式。
// 请注意，在一个到处都是模块的世界中，您几乎不需要一个 IIFE 。
// immediately-invoked function expression (IIFE) 立即调用的函数表达式
(function () {
    console.log('Welcome to the Internet. Please follow me.');
}());


// 7.3 切记不要在非功能块中声明函数 (if, while, 等)。 将函数赋值给变量。
// 浏览器允许你这样做，但是他们都有不同的解释，这是个坏消息。 eslint: no-loop-func


// 7.4 注意: ECMA-262 将 block 定义为语句列表。 函数声明不是语句。
// bad
if (currentUser) {
    function test() {
        console.log('Nope.');
    }
}

// good
let test;
if (currentUser) {
    test = () => {
        console.log('Yup.');
    };
}


// 7.5 永远不要定义一个参数为 arguments。 这将会优先于每个函数给定范围的 arguments 对象。
// bad
function foo(name, options, arguments) {
    // ...
}

// good
function foo(name, options, args) {
    // ...
}


// 7.6 不要使用 arguments, 选择使用 rest 语法 ... 代替。 eslint: prefer-rest-params
// 为什么? ... 明确了你想要拉取什么参数。 更甚, rest 参数是一个真正的数组，而不仅仅是类数组的 arguments 。
// bad
function concatenateAll() {
    const args = Array.prototype.slice.call(arguments);
    return args.join('');
}

// good
function concatenateAll(...args) {
    return args.join('');
}


// 7.7 使用默认的参数语法，而不是改变函数参数。
// really bad
function handleThings(opts) {
    // No! We shouldn’t mutate function arguments.
    // Double bad: if opts is falsy it'll be set to an object which may
    // be what you want but it can introduce subtle bugs.
    opts = opts || {};
    // ...
}

// still bad
function handleThings(opts) {
    if (opts === void 0) {
        opts = {};
    }
    // ...
}

// good
function handleThings(opts = {}) {
    // ...
}


// 7.8 避免使用默认参数的副作用。
// 为什么? 他们很容易混淆。
var b = 1;
// bad
function count(a = b++) {
    console.log(a);
}
count();  // 1
count();  // 2
count(3); // 3
count();  // 3


// 7.9 总是把默认参数放在最后。
// bad
function handleThings(opts = {}, name) {
    // ...
}

// good
function handleThings(name, opts = {}) {
    // ...
}

// 7.10 永远不要使用函数构造器来创建一个新函数。 eslint: no-new-func
// 为什么? 以这种方式创建一个函数将对一个类似于 eval() 的字符串进行计算，这将打开漏洞。
// bad
var add = new Function('a', 'b', 'return a + b');

// still bad
var subtract = Function('a', 'b', 'return a - b');


// 7.11 函数签名中的间距。 eslint: space-before-function-paren space-before-blocks
// 为什么? 一致性很好，在删除或添加名称时不需要添加或删除空格。
// bad
const f = function(){};
const g = function (){};
const h = function() {};

// good
const x = function () {};
const y = function a() {};


// 7.12 没用变异参数。 eslint: no-param-reassign
// 为什么? 将传入的对象作为参数进行操作可能会在原始调用程序中造成不必要的变量副作用。
// bad
function f1(obj) {
    obj.key = 1;
}

// good
function f2(obj) {
    const key = Object.prototype.hasOwnProperty.call(obj, 'key') ? obj.key : 1;
}

// 7.13 不要再赋值参数。 eslint: no-param-reassign
// 为什么? 重新赋值参数会导致意外的行为，尤其是在访问 arguments 对象的时候。 它还可能导致性能优化问题，尤其是在 V8 中。
// bad
function f1(a) {
    a = 1;
    // ...
}

function f2(a) {
    if (!a) { a = 1; }
    // ...
}

// good
function f3(a) {
    const b = a || 1;
    // ...
}

function f4(a = 1) {
    // ...
}
