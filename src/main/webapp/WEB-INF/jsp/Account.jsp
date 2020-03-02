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
    <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button></div>
</script>
<script type="text/html" id="accbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加账户',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Accountadd',
            area: ['1200px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: ['20px', '50px']
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#acc1'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#accbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,method: 'post'
            ,request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
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
            ,id: 'testReload'
            ,page: true //开启分页,
            ,data:[{
                "id":"1"
                ,"userName":"2"
                ,"userPassword":"3"
                ,"userType":"1"
                ,"realname":"5"
                ,"userTelephone":"6"
                ,"userState":"7"
                ,"userPostion":"8"
            }]
        });

        //搜素
        var $ = layui.$, active  = {
            reload: function(){
                var demoReload = $('#demoReload');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                }, 'data');
            }
        };
        $('.search1 .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听工具条
        table.on('tool(accfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            } else if (obj.event === 'edit') {
                layer.open({
                    title: '账户信息修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Accountmodify',
                    area: ['1200px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#accmodify").click();
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
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });
</script>
</html>
