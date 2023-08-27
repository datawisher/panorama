// 引用
// 2.1 使用 const 定义你的所有引用；避免使用 var。 eslint: prefer-const, no-const-assign
// 这样能够确保你不能重新赋值你的引用，否则可能导致错误或者产生难以理解的代码。

// bad
var a = 1;
var b = 2;

// good
const a = 1;
const b = 2;


// 2.2 如果你必须重新赋值你的引用， 使用 let 代替 var。 eslint: no-var
// let 是块级作用域，而不像 var 是函数作用域.

// bad
var count = 1;
if (true) {
  count += 1;
}

// good, use the let.
let count = 1;
if (true) {
  count += 1;
}

// 2.3 注意，let 和 const 都是块级范围的。
// const 和 let 只存在于他们定义的块中。
{
  let a = 1;
  const b = 1;
}
console.log(a); // ReferenceError
console.log(b); // ReferenceError