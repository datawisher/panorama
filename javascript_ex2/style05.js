// 解构
// 5.1 在访问和使用对象的多个属性的时候使用对象的解构。 eslint: prefer-destructuring
// 解构可以避免为这些属性创建临时引用。
// bad
function getFullName(user) {
    const firstName = user.firstName;
    const lastName = user.lastName;
  
    return `${firstName} ${lastName}`;
  }
  
  // good
  function getFullName(user) {
    const { firstName, lastName } = user;
    return `${firstName} ${lastName}`;
  }
  
  // best
  function getFullName({ firstName, lastName }) {
    return `${firstName} ${lastName}`;
  }

// 5.2 使用数组解构。 eslint: prefer-destructuring
const arr = [1, 2, 3, 4];

// bad
const first = arr[0];
const second = arr[1];

// good
const [first, second] = arr;

// 5.3 对于多个返回值使用对象解构，而不是数组解构。
// 你可以随时添加新的属性或者改变属性的顺序，而不用修改调用方。
// bad
function processInput(input) {
    // 处理代码...
    return [left, right, top, bottom];
  }
  
  // 调用者需要考虑返回数据的顺序。
  const [left, __, top] = processInput(input);
  
  // good
  function processInput(input) {
    // 处理代码...
    return { left, right, top, bottom };
  }
  
  // 调用者只选择他们需要的数据。
  const { left, top } = processInput(input);

