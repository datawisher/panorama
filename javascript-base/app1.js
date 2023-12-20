/**
 * null 和 undefined
 */
if (!undefined) {
    console.log('undefined is false')
} else {
    console.log('undefined is true')
}
// undefined is false


if (!null) {
    console.log('null is false');
}
// null is false

if (undefined == null) {
    console.log('true');
}
// true

console.log(Number(null)); // 0
console.log(Number(undefined)); // NaN



/**
 * 布尔值
 */
if ('') {
    console.log('true');
} // 没有任何输出
