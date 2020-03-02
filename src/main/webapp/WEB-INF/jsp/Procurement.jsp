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
    <%--<div class="row">
        <div class="col-sm-6 col-md-3 layui-bg-blue">
            <div class="value" style="text-align:center">
                <a href="#" style="color: #e1edf7">
                    <h1 id="count1">10</h1>
                </a>
                <p>石头剩余重量\kg</p>
            </div>
        </div>
        <div class="col-sm-6 col-md-3 layui-bg-cyan">
            <div class="value" style="text-align:center">
                <a href="#" style="color: #e1edf7">
                    <h1 id="count2">1</h1>
                </a>
                <p>沙子剩余重量\kg</p>
            </div>
        </div>
        <div class="col-sm-6 col-md-3 layui-bg-green">
            <div class="value" style="text-align:center">
                <a href="#" style="color: #e1edf7">
                    <h1 id="count3">50</h1>
                </a>
                <p>水泥剩余重量\kg</p>
            </div>
        </div>
        <div class="col-sm-6 col-md-3 layui-bg-orange">
            <div class="value" style="text-align:center">
                <a href="#" style="color: #e1edf7">
                    <h1 id="count4">0</h1>
                </a>
                <p>添加剂剩余重量\kg</p>
            </div>
        </div>
    </div>--%>
    <div class="layui-fluid">
        <h2 style="color:#000000;padding: 10px">原材料储存管理</h2>
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="layui-row layui-col-space10" style="height: 100px ">
                    <div class="layui-col-md3 layui-bg-blue" style="height: 100px ;text-align:center;padding: 20px">
                        <h1 style="color: #e1edf7">10</h1>
                        <p>石头剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-cyan" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count2">1</h1>
                        </a>
                        <p>沙子剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-green" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count3">50</h1>
                        </a>
                        <p>水泥剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-orange" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count4">0</h1>
                        </a>
                        <p>添加剂剩余重量\kg</p>
                    </div>
                </div>
            </div>
            <hr class="layui-bg-gray">
            <div class="layui-card-body">
                <table class="layui-hide" id="pro1" lay-filter="profilter1"></table>
            </div>
        </div>
    </div>
</body>
<script type="text/html" id="probar1">
    <div class="search1">
        搜索ID：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon"></i></button>
    </div>
</script>
<script type="text/html" id="probar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加采购',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Procurementadd',
            area: ['1200px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset:['20px', '50px']
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#pro1'
            , url: '/test/testdata1.json'
            , toolbar: '#probar1'
            , defaultToolbar: ['filter', 'print']
            , method: 'post'
            , request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            , cols: [[ //标题栏
                {field: 'Procurement_id', title: '采购单编号', width: 120, rowspan: 2, sort: true}
                , {field: 'Procurement_name', title: '采购人', width: 120, rowspan: 2}
                , {field: 'Procurement_time', title: '采购时间', width: 210, rowspan: 2}
                , {field: 'Procurement_type', title: '采购类型', width: 120, rowspan: 2}
                , {field: 'Procurement_amount', title: '采购数量', width: 120, rowspan: 2}
                , {field: 'Procurement_price', title: '采购单价', width: 100}
                , {field: 'Procurement_address', title: '采购地点', width: 100}
                , {field: 'Procurement_priceamount', title: '采购总价', width: 100}
                , {fixed: 'right', title: '操作', width: 200, rowspan: 2, align: 'center', toolbar: '#probar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,id: 'testReload'
            , page: true //开启分页,
            , limit: 10
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
        table.on('tool(profilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.Contract_id + ' 的查看操作');
            }  else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        })
    });
</script>
</html>
