// 1.
//
//     let a = 10;
//     var b = 1;
// }

// console.log(a); // ReferenceError: a is not defined
// console.log(b); // 1

// 2.
// for (let i = 0; i < 10; i++) {
//     // ...
// }

// console.log(i); // ReferenceError: i is not defined

// 3.
// var a = [];
// for (var i = 0; i < 10; i++) {
//   a[i] = function () {
//     console.log(i);
//   };
// }
// a[6](); // 10

// var a = [];
// for (let i = 0; i < 10; i++) {
//   a[i] = function () {
//     console.log(i);
//   };
// }
// a[6](); // 6

// 4.
// for (let i = 0; i < 3; i++) {
//     let i = 'abc';
//     console.log(i);
// }
//   // abc
//   // abc
//   // abc

// 5.
// function fn() {
//     console.log(arguments)
// }
// fn(1,3,4)

// =================================
// const a = [];
// a.push('Hello'); // 可执行
// a.length = 0;    // 可执行
// a = ['Dave'];    // 报错

// =================================
// const foo = Object.freeze({});
// // 常规模式时，下面一行不起作用；
// // 严格模式时，该行会报错
// foo.prop = 123;

// =================================
// 1. 数组的解构赋值
// let [a, b, c] = [1, 2, 3];
// let [foo, [[bar], baz]] = [1, [[2], 3]];
// foo // 1
// bar // 2
// baz // 3
//
// let [ , , third] = ["foo", "bar", "baz"];
// third // "baz"
//
// let [x, , y] = [1, 2, 3];
// x // 1
// y // 3
//
// let [head, ...tail] = [1, 2, 3, 4];
// head // 1
// tail // [2, 3, 4]
//
// let [x, y, ...z] = ['a'];
// x // "a"
// y // undefined
// z // []

// =================================
