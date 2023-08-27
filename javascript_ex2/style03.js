// 对象
// 3.1 使用字面语法来创建对象。 eslint: no-new-object
// bad
const item = new Object();

// good
const item = {};

// 3.2 在创建具有动态属性名称的对象时使用计算属性名。
// 它允许你在一个地方定义对象的所有属性。
function getKey(k) {
  return `a key named ${k}`;
}

// bad
const obj = {
  id: 5,
  name: 'San Francisco',
};
obj[getKey('enabled')] = true;

// good
const obj = {
  id: 5,
  name: 'San Francisco',
  [getKey('enabled')]: true,
};

// 3.3 使用对象方法的缩写。 eslint: object-shorthand
// bad
const atom = {
  value: 1,

  addValue: function (value) {
    return atom.value + value;
  },
};

// good
const atom = {
  value: 1,

  addValue(value) {
    return atom.value + value;
  },
};

// 3.4 使用属性值的缩写。 eslint: object-shorthand
// 它的写法和描述较短。
const lukeSkywalker = 'Luke Skywalker';

// bad
const obj = {
  lukeSkywalker: lukeSkywalker,
};

// good
const obj = {
  lukeSkywalker,
};

// 3.5 在对象声明的时候将简写的属性进行分组。
// 这样更容易的判断哪些属性使用的简写。
const anakinSkywalker = 'Anakin Skywalker';
const lukeSkywalker = 'Luke Skywalker';

// bad
const obj = {
  episodeOne: 1,
  twoJediWalkIntoACantina: 2,
  lukeSkywalker,
  episodeThree: 3,
  mayTheFourth: 4,
  anakinSkywalker,
};

// good
const obj = {
  lukeSkywalker,
  anakinSkywalker,
  episodeOne: 1,
  twoJediWalkIntoACantina: 2,
  episodeThree: 3,
  mayTheFourth: 4,
};

// 3.6 只使用引号标注无效标识符的属性。 eslint: quote-props
// 总的来说，我们认为这样更容易阅读。 它提升了语法高亮显示，并且更容易通过许多 JS 引擎优化。
// bad
const bad = {
  'foo': 3,
  'bar': 4,
  'data-blah': 5,
};

// good
const good = {
  foo: 3,
  bar: 4,
  'data-blah': 5,
};

// 3.7 不能直接调用 Object.prototype 的方法，如： hasOwnProperty 、 propertyIsEnumerable 和 isPrototypeOf。
// 这些方法可能被以下问题对象的属性追踪 - 相应的有 { hasOwnProperty: false } - 或者，对象是一个空对象 (Object.create(null))。
// bad
console.log(object.hasOwnProperty(key));

// good
console.log(Object.prototype.hasOwnProperty.call(object, key));

// best
const has = Object.prototype.hasOwnProperty; // 在模块范围内的缓存中查找一次
/* or */
import has from 'has'; // https://www.npmjs.com/package/has
// ...
console.log(has.call(object, key));

// 3.8 更喜欢对象扩展操作符，而不是用 Object.assign 浅拷贝一个对象。 使用对象的 rest 操作符来获得一个具有某些属性的新对象。
// very bad
const original = { a: 1, b: 2 };
const copy = Object.assign(original, { c: 3 }); // 变异的 `original` ಠ_ಠ
delete copy.a; // 这....

// bad
const original = { a: 1, b: 2 };
const copy = Object.assign({}, original, { c: 3 }); // copy => { a: 1, b: 2, c: 3 }

// good
const original = { a: 1, b: 2 };
const copy = { ...original, c: 3 }; // copy => { a: 1, b: 2, c: 3 }

const { a, ...noA } = copy; // noA => { b: 2, c: 3 }