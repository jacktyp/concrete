<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/3
  Time: 10:01
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
    <h2 style="color:#000000;padding: 20px">实验记录</h2>
    <div class="layui-card">
        <table class="layui-hide" id="mix1" lay-filter="mixfilter1"></table>
    </div>
</div>
<%--
<fieldset class="layui-elem-field site-demo-button">
    <button type="button" onclick="addtest();" class="layui-btn layui-btn-normal layui-btn-lg layui-btn-radius">添加实验记录</button>
</fieldset>
--%>

<script type="text/html" id="mixbar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
</script>
<script type="text/html" id="mixbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title: '添加实验',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Mixproportionadd',
            area: ['1200px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset:  ['20px', '50px']
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#mix1'
            //,url: '/test/testdata1.json'
            //,count: total//数据总数，从服务端得到
            ,toolbar: '#mixbar1' //开启头部工具栏，并为其绑定左侧模板
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
                , {field: 'name', title: '实验名称', width: 120 ,rowspan: 2}
                , {field: 'concretegrade', title: '混凝土等级', width: 120 ,rowspan: 2}
                , {field: 'mp', title: '混泥土配合比', width: 120 ,rowspan: 2}
                , {field: 'state', title: '是否合格',templet: '#switchTpl', width: 100}
                /* , {align: 'center', title: '所需各种原材料数量', colspan: 5} //colspan即横跨的单元格数，这种情况下不用设置field和width
             ], [*/
                , {field: 'stone', title: '每方混凝土的石头量\kg', width: 100}
                , {field: 'sand', title: '每方混凝土的沙子量\kg', width: 100}
                , {field: 'cement', title: '每方混凝土的水泥量\kg', width: 100}
                , {field: 'water', title: '每方混凝土的水量\kg', width: 100}
                , {field: 'additive', title: '每方混凝土的添加剂量\kg', width: 100}
                , {field: 'remark', title: '备注', width: 100}

                , {field: 'experiment', title: '实验人', width: 120,unresize: true,rowspan: 2}
                , {field: 'experimenttime', title: '实验日期', width: 210 ,rowspan: 2}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#mixbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
            ,data:[{
                "id":"1"
                ,"name":"1"
                ,"concretegrade":"1"
                ,"mp":"1"
                ,"state":"1"
                ,"stone":"1"
                ,"sand":"1"
                ,"cement":"1"
                ,"water":"1"
                ,"additive":"1"
                ,"remark":"1"
                ,"experiment":"1"

            }]
        });

        //监听工具条
        table.on('tool(mixfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            }  else if (obj.event === 'edit') {
                layer.open({
                    title: '实验信息修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Mixproportionmodify',
                    area: ['1200px', '620px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['20px', '50px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#mixmodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="name"]').val(data.name);
                        othis.find('input[name="concretegrade"]').val(data.concretegrade);
                        othis.find('input[name="mp"]').val(data.mp);
                        othis.find('input[name="state"]').val(data.state);
                        othis.find('input[name="stone"]').val(data.stone);
                        othis.find('input[name="sand"]').val(data.sand);
                        othis.find('input[name="cement"]').val(data.cement);
                        othis.find('input[name="water"]').val(data.water);
                        othis.find('input[name="additive"]').val(data.additive);
                        othis.find('input[name="remark"]').val(data.remark);
                        othis.find('input[name="experiment"]').val(data.experiment);
                        othis.find('input[name="experimenttime"]').val(data.experimenttime);
                    }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });
</script>

</body>
</html>
<%--

<table class="layui-hide" id="demo3" lay-filter="test3"></table>

<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/layui/layui.all.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/html" id="barDemo3">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            type: 2,
            content: 'http://localhost:8080/concrete/user/Mixproportionadd',
            area: ['1000px', '500px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: 'lt'
        })

    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#demo2'
            ,url: '/test/testdata1.json'
            ,toolbar: '#toolbarDemo2' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
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
                {field: 'Mixproportion_id', title: '配合比编号', width: 120 ,rowspan: 2, sort: true}
                , {field: 'Mixproportion_name', title: '配合比名称', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_concretegrade', title: '混凝土等级', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_mp', title: '混泥土配合比', width: 120 ,rowspan: 2}
                , {field: 'Mixproportion_state', title: '是否合格',templet: '#switchTpl', width: 100}
                /* , {align: 'center', title: '所需各种原材料数量', colspan: 5} //colspan即横跨的单元格数，这种情况下不用设置field和width
             ], [*/
                , {field: 'Mixproportion_stone', title: '每方混凝土的石头量\kg', width: 100}
                , {field: 'Mixproportion_sand', title: '每方混凝土的沙子量\kg', width: 100}
                , {field: 'Mixproportion_cement', title: '每方混凝土的水泥量\kg', width: 100}
                , {field: 'Mixproportion_water', title: '每方混凝土的水量\kg', width: 100}
                , {field: 'Mixproportion_additive', title: '每方混凝土的添加剂量\kg', width: 100}

                , {field: 'Notification_registrant', title: '实验人', width: 120,unresize: true,rowspan: 2}
                , {field: 'Notification_registranttime', title: '实验日期', width: 210 ,rowspan: 2}
                , {fixed: 'right',title: '操作', width: 240 ,rowspan: 2, align: 'center', toolbar: '#barDemo3'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页,
            ,limit: 10
        });

        //监听合格操作
        form.on('switch(sexDemo)', function(obj){
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        });

        //监听工具条
        table.on('tool(test3)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            } else if (obj.event === 'edit') {
                layer.alert('编辑行：<br>' + JSON.stringify(data))
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        })

    });
</script>

</body>
</html>
--%>
