/**
 * this 关键字
 */
var A = {
    name: '张三',
    describe: function () {
        return '姓名：' + this.name;
    }
};

var B = {
    name: '李四'
};

B.describe = A.describe;
console.log(B.describe()); // "姓名：李四"
// this的指向是可变的

console.log("##########");
var A = {
    name: '刘备',
    describe: function () {
        return '姓名：' + this.name;
    }
};

var name = '张飞';
var f = A.describe;
console.log(f());


console.log("##########");
var f = function () {
    console.log(this.x);
}

var x = 1;
var obj = {
    f: f,
    x: 2,
};

// 单独执行
f() // undefined

// obj 环境执行
obj.f() // 2


/**
 * 避免多层 this
 */
var o = {
    f1: function() {
      console.log(this);
      var that = this;
      var f2 = function() {
        console.log(that);
      }();
    }
  }
  
  o.f1()
  // Object
  // Object


/**
 * 避免数组处理方法中的 this
 */
var o = {
    v: 'hello',
    p: ['a1', 'a2'],
    f: function f() {
        var that = this;
        this.p.forEach(function (item) {
            console.log(that.v + ' ' + item);
        });
    }
}

o.f() 
// hello a1 
// hello a2


/**
 * 避免回调函数中的 this
 * 回调函数中的this往往会改变指向，最好避免使用。
 */
var o = new Object();
o.f = function () {
  console.log(this === o);
}

// jQuery 的写法
$('#button').on('click', o.f);

/**
 * 绑定 this 的方法
 */