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
