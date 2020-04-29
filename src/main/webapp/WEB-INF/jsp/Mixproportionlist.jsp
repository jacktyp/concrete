<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/3
  Time: 13:59
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
    <h2 style="color:#000000;padding: 20px">配合比制度表</h2>
    <div class="layui-card">
        <table class="layui-hide" id="mixlist1" lay-filter="mixlistfilter1"></table>
    </div>
</div>
</body>
<script type="text/html" id="mixlistbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#mixlist1'
            ,url: 'http://localhost:8080/concrete/mixproportion/selectMixproportion'
            ,toolbar: '#mixbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 120 ,rowspan: 2, sort: true}
                , {field: 'name', title: '配合比名称', width: 120 ,rowspan: 2}
                , {field: 'concretegrade', title: '混凝土等级', width: 120 ,rowspan: 2}
                , {field: 'mp', title: '混泥土配合比', width: 120 ,rowspan: 2}
                //, {field: 'state', title: '是否合格',templet: '#switchTpl', width: 100}
                , {field: 'stone', title: '每方混凝土的石头量\kg', width: 100}
                , {field: 'sand', title: '每方混凝土的沙子量\kg', width: 100}
                , {field: 'cement', title: '每方混凝土的水泥量\kg', width: 100}
                , {field: 'water', title: '每方混凝土的水量\kg', width: 100}
                , {field: 'additive', title: '每方混凝土的添加剂量\kg', width: 100}
                , {field: 'remark', title: '备注', width: 100}
                //, {field: 'experiment', title: '实验人', width: 120,unresize: true,rowspan: 2}
                //, {field: 'experimenttime', title: '实验日期', width: 210 ,rowspan: 2}
                , {fixed: 'right', title: '操作', width: 240, rowspan: 2, align: 'center', toolbar: '#mixlistbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            , page: true //开启分页,
            , limit: 10
        });
        //监听工具条
        table.on('tool(mixlistfilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('配合比编号：' + data.id + '<br>'
                    +'配合比名称：' + data.name + '<br>'
                    +'混凝土等级：' + data.concretegrade + '<br>'
                    +'混泥土配合比：' + data.mp + '<br>'
                    +'每方混凝土的石头量：' + data.stone + '<br>'
                    +'每方混凝土的沙子量：' + data.sand + '<br>'
                    +'每方混凝土的水泥量：' + data.cement + '<br>'
                    +'每方混凝土的水量：' + data.water + '<br>'
                    +'每方混凝土的添加剂量：' + data.additive + '<br>'
                    +'备注：' + data.remark + '<br>');
            }  else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/mixproportion/deleteMixproportion",
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
        })

    });
</script>
</html>
