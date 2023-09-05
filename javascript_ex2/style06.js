// 字符
// 6.1 使用单引号 '' 定义字符串。 eslint: quotes
// bad
const name = "Capt. Janeway";

// bad - 模板文字应该包含插值或换行。
const name = `Capt. Janeway`;

// good
const name = 'Capt. Janeway';


// 6.2 使行超过100个字符的字符串不应使用字符串连接跨多行写入。
// 为什么? 断开的字符串更加难以工作，并且使代码搜索更加困难。
// bad
const errorMessage = 'This is a super long error that was thrown because \
of Batman. When you stop to think about how Batman had anything to do \
with this, you would get nowhere \
fast.';

// bad
const errorMessage = 'This is a super long error that was thrown because ' +
  'of Batman. When you stop to think about how Batman had anything to do ' +
  'with this, you would get nowhere fast.';

// good
const errorMessage = 'This is a super long error that was thrown because of Batman. When you stop to think about how Batman had anything to do with this, you would get nowhere fast.';


// 6.3 当以编程模式构建字符串时，使用字符串模板代替字符串拼接。 eslint: prefer-template template-curly-spacing
// 为什么? 字符串模板为您提供了一种可读的、简洁的语法，具有正确的换行和字符串插值特性。
// bad
function sayHi(name) {
    return 'How are you, ' + name + '?';
  }

// bad
function sayHi(name) {
return ['How are you, ', name, '?'].join();
}

// bad
function sayHi(name) {
return `How are you, ${ name }?`;
}

// good
function sayHi(name) {
return `How are you, ${name}?`;
}


// 6.4 不要在字符串上使用 eval() ，它打开了太多漏洞。 eslint: no-eval


// 6.5 不要转义字符串中不必要的字符。 eslint: no-useless-escape
// 为什么? 反斜杠损害了可读性，因此只有在必要的时候才会出现。

// bad
const foo = '\'this\' \i\s \"quoted\"';

// good
const foo = '\'this\' is "quoted"';
const foo = `my name is '${name}'`;