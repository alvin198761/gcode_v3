/*角色模拟数据,作者:高振中,日期:2018-08-10 09:21:48*/
'use strict';
var Mock = require('mockjs')
var Random = Mock.Random;
module.exports = {

  'POST /api/adminRole/queryPage': function (req, res, next) {
    var data = Mock.mock({
      "content|10": [{
        id: "@integer(100,200)",//主键
        name: "@word(5,10)",//名称
        remark: "@word(5,10)",//备注
      }],
      "number": '@integer(100,200)',
      "size": 10,
      "totalElements": 500,
    });
    setTimeout(function () {
      res.json(data);
    }, 500);
  },
  'POST /api/adminRole/update': function (req, res, next) {
    setTimeout(function () {
      res.json({});
    }, 500);
  },
  'POST /api/adminRole/save': function (req, res, next) {
    setTimeout(function () {
      res.json({});
    }, 500);
  },
  'POST /api/adminRole/queryList': function (req, res, next) {
    var data = Mock.mock({
      "content|10": [{
        id: "@integer(100,200)",//主键
        name: "@word(5,10)",//名称
        remark: "@word(5,10)",//备注
      }]
    });
    setTimeout(function () {
      res.json(data.content);
    }, 500);
  },
  'POST /api/adminRole/delete': function (req, res, next) {
    setTimeout(function () {
      res.json({});
    }, 500);
  },
}