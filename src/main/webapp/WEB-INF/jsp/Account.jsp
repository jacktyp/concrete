<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/3/1
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>搅拌站业务流程系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/layui/layui.all.js" charset="utf-8"></script>
    <script src="/layui/jquery.min.js"></script>
</head>

<body>
<div class="layui-fluid">
    <h2 style="color:#000000;padding: 10px">账户管理</h2>
    <div class="layui-card">
        <table class="layui-hide" id="acc1" lay-filter="accfilter1"></table>
    </div>
</div>
</body>

<script type="text/html" id="accbar1">
    <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-add-1">添加用户</i></button>
</script>
<script type="text/html" id="accbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加账户',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Accountadd',
            area: ['1000px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: ['10px', '20px']
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#acc1'
            ,url: 'http://localhost:8080/concrete/user/findAllUser'
            ,toolbar: '#accbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 120 ,rowspan: 2, sort: true}
                , {field: 'userName', title: '用户名', width: 120 ,rowspan: 2}
                , {field: 'userPassword', title: '用户密码', width: 120 ,rowspan: 2}
                , {field: 'userType', title: '用户类型', width: 120 ,rowspan: 2}
                , {field: 'realname', title: '真实姓名', width: 120 ,rowspan: 2}
                , {field: 'userTelephone', title: '手机电话', width: 120 ,rowspan: 2}
                , {field: 'userState', title: '是否在线', width: 120 ,rowspan: 2}
                , {field: 'userPostion', title: '用户职位信息', width: 100}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#accbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
        });

        //监听工具条
        table.on('tool(accfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('用户编号：' + data.id + '<br>'
                    +'用户名：' + data.userName + '<br>'
                    +'用户类型：' + data.userType + '<br>'
                    +'真实姓名：' + data.realname + '<br>'
                    +'手机电话：' + data.userTelephone + '<br>'
                    +'是否在线：' + data.userState + '<br>'
                    +'用户职位信息：' + data.userPostion + '<br>');
            } else if (obj.event === 'edit') {
                layer.open({
                    title: '账户信息修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Accountmodify',
                    area: ['1000px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['10px', '20px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#usermodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="userName"]').val(data.userName);
                        othis.find('input[name="realname"]').val(data.realname);
                        othis.find('input[name="userPassword"]').val(data.userPassword);
                        othis.find('input[name="userType"]').val(data.userType);
                        othis.find('input[name="userTelephone"]').val(data.userTelephone);
                        othis.find('input[name="userState"]').val(data.userState);
                        othis.find('input[name="userPostion"]').val(data.userPostion);
                    }
                });
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/user/deleteUser",
                        type: "POST",
                        data: {id:data.id},
                        success: function (msg) {
                            if (msg != null) {
                                //删除这一行
                                obj.del();
                                //关闭弹框
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    });
                    return false;
                });
            }
        });
    });
</script>
</html>
