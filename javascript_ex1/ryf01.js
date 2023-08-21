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
function fn() {
    console.log(arguments)
}
fn(1,3,4)