//获取cookie的值
function getCookie(name) {
    var strcookie = document.cookie;    //获取cookie字符串
    var arrcookie = strcookie.split(";");                //分割字符串
    //匹配遍历
    for (var i=0;i<arrcookie.length;i++){
        var arr = arrcookie[i].split("=");
        if((arr[0].trim())== name){
            return arr[1];
        }
    }
    return "";
}

/*
    删除cookie中的token
 */
function delCookie(name) {
    var exp = new Date();
    exp.setTime(exp.getTime()-10)
    var cookie = getCookie(name);
    if (cookie!=null){
        document.cookie =name.trim()+ "=" +cookie+";exprie="+exp.toGMTString()+";path=/"
    }
}