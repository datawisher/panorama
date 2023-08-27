// 数组
// 4.1 使用字面语法创建数组。 eslint: no-array-constructor
// bad
const items = new Array();

// good
const items = [];

// 4.2 使用 Array#push 取代直接赋值来给数组添加项。
const someStack = [];

// bad
someStack[someStack.length] = 'abracadabra';

// good
someStack.push('abracadabra');

// 4.3 使用数组展开方法 ... 来拷贝数组。
// bad
const len = items.length;
const itemsCopy = [];
let i;

for (i = 0; i < len; i += 1) {
  itemsCopy[i] = items[i];
}

// good
const itemsCopy = [...items];

// 4.4 将一个类数组对象转换成一个数组， 使用展开方法 ... 代替 Array.from。
const foo = document.querySelectorAll('.foo');

// good
const nodes = Array.from(foo);

// best
const nodes = [...foo];

// 4.5 对于对迭代器的映射，使用 Array.from 替代展开方法 ... ， 因为它避免了创建中间数组。
// bad
const baz = [...foo].map(bar);

// good
const baz = Array.from(foo, bar);


// 4.6 在数组回调方法中使用 return 语句。 如果函数体由一个返回无副作用的表达式的单个语句组成，那么可以省略返回值， 具体查看 8.2。 eslint: array-callback-return
// good
[1, 2, 3].map((x) => {
    const y = x + 1;
    return x * y;
  });
  
// good
[1, 2, 3].map(x => x + 1);

// bad - 没有返回值，意味着在第一次迭代后 `acc` 没有被定义
[[0, 1], [2, 3], [4, 5]].reduce((acc, item, index) => {
const flatten = acc.concat(item);
acc[index] = flatten;
});

// good
[[0, 1], [2, 3], [4, 5]].reduce((acc, item, index) => {
const flatten = acc.concat(item);
acc[index] = flatten;
return flatten;
});

// bad
inbox.filter((msg) => {
const { subject, author } = msg;
if (subject === 'Mockingbird') {
    return author === 'Harper Lee';
} else {
    return false;
}
});

// good
inbox.filter((msg) => {
const { subject, author } = msg;
if (subject === 'Mockingbird') {
    return author === 'Harper Lee';
}

return false;
});


// 4.7 如果数组有多行，则在开始的时候换行，然后在结束的时候换行。
// bad
const arr = [
    [0, 1], [2, 3], [4, 5],
  ];
  
const objectInArray = [{
id: 1,
}, {
id: 2,
}];

const numberInArray = [
1, 2,
];

// good
const arr = [[0, 1], [2, 3], [4, 5]];

const objectInArray = [
{
    id: 1,
},
{
    id: 2,
},
];

const numberInArray = [
1,
2,
];