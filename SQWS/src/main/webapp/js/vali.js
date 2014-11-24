/**
 * Created by shui on 2014/11/16.
 */
$.extend($.fn.validatebox.defaults.rules, {
    equals: {
        validator: function(value,param){
            return value == $(param[0]).val();
        },
        message: '两个密码输入不一致.'
    },
    minLen: {
        validator: function(value,param){
            return value.length >= param[0];
        },
        message: '不能输入小于5位.'
    }
})