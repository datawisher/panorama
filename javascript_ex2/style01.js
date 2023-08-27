// 类型
// 1.1 原始值: 当你访问一个原始类型的时候，你可以直接使用它的值。
// string
// number
// boolean
// null
// undefined
// symbol
const foo = 1;
let bar = foo;

bar = 9;

console.log(foo, bar); // => 1, 9


// 1.2 复杂类型: 当你访问一个复杂类型的时候，你需要一个值得引用。
// object
// array
// function
const foo = [1, 2];
const bar = foo;

bar[0] = 9;

console.log(foo[0], bar[0]); // => 9, 9