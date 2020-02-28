<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/1/29
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
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
    <h2 style="color:#000000;padding: 20px">合同列表</h2>
    <div class="layui-card">
        <table class="layui-hide" id="contractlist" lay-filter="conteractlist"></table>
    </div>
</div>
</body>
<script type="text/html" id="conbar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/html" id="conbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">添加通知单</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#contractlist'
            ,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#conbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
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
                {field: 'Contract_id', title: '合同编号', width: 120, sort: true}
                , {field: 'Contract_name', title: '客户名称', width: 120}
                , {field: 'Contract_amount', title: '混凝土需求量\m³', width: 160}
                , {field: 'Contract_concretegrade', title: '混泥土等级', width: 120}
                , {field: 'Contract_registrant', title: '合同登记人', width: 120}
                , {field: 'Contract_registranttime', title: '合同登记日期', width: 210}
                , {fixed: 'right',title: '操作', width: 280, align: 'center', toolbar: '#conbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,id: 'testReload'
            ,page: true //开启分页,id
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
        table.on('tool(conteractlist)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('合同编号：' + data.Contract_id + '<br>'
                    +'客户名称：' + data.Contract_name + '<br>'
                    +'混凝土需求量：' + data.Contract_amount + '<br>'
                    +'混泥土等级：' + data.Contract_concretegrade + '<br>'
                    +'合同登记人：' + data.Contract_registrant + '<br>'
                    +'合同登记日期：' + data.Contract_registranttime);
            } else if (obj.event === 'add') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
                layer.open({
                    type: 2,
                    content: 'http://localhost:8080/concrete/user/Noticeadd',
                    area: ['1200px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: 'lt'
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