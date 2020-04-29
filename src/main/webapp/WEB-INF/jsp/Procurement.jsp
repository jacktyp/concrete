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
    <script src="/layui/jquery.min.js"></script>
</head>

<body>
    <div class="layui-fluid">
        <h2 style="color:#000000;padding: 10px">原材料储存管理</h2>
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="layui-row layui-col-space10" style="height: 100px ">
                    <div class="layui-col-md3 layui-bg-blue" style="height: 100px ;text-align:center;padding: 20px">
                        <h1 style="color: #e1edf7"><span id="stone"></span></h1>
                        <p>石头剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-cyan" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count2"><span id="sand"></span></h1>
                        </a>
                        <p>沙子剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-green" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count3"><span id="cement"></span></h1>
                        </a>
                        <p>水泥剩余重量\kg</p>
                    </div>
                    <div class="layui-col-md3 layui-bg-orange" style="height: 100px ;text-align:center;padding: 20px">
                        <a href="#" style="color: #e1edf7">
                            <h1 id="count4"><span id="additive"></span></h1>
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
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-add-1">添加采购</i></button>
    </div>
</script>
<script type="text/html" id="probar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加采购',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Procurementadd',
            area: ['1000px', '400px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset:['10px', '20px']
        })
    }
</script>
<script>
    var stone, sand, cement, additive;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/concrete/material/selectMaterial",
        async: false,
        success: function (data) {
            //console.log(data);
            var obj = data["msg"];
            //console.log(obj);
            var obj2 = JSON.parse(obj);
            //console.log(obj2);
            sand = obj2["sand"];
            document.getElementById("sand").innerText = sand;
            stone = obj2["stone"];
            document.getElementById("stone").innerText = stone;
            cement = obj2["cement"];
            document.getElementById("cement").innerText = cement;
            additive = obj2["additive"];
            document.getElementById("additive").innerText = additive;
            //console.log(stone+"  "+sand+"  "+cement+"  "+additive);
        }
    });

    layui.use(['table'], function () {
        var table = layui.table;

        //展示已知数据
        table.render({
            elem: '#pro1'
            ,url: 'http://localhost:8080/concrete/procure/findAllProcure'
            ,toolbar: '#probar1'
            ,defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[ //标题栏
                {field: 'id', title: '采购单编号', width: 120, rowspan: 2, sort: true}
                , {field: 'name', title: '采购人', width: 120, rowspan: 2}
                , {field: 'time', title: '采购时间', width: 210, rowspan: 2}
                , {field: 'type', title: '采购类型', width: 120, rowspan: 2}
                , {field: 'amount', title: '采购数量', width: 120, rowspan: 2}
                , {field: 'price', title: '采购单价', width: 100}
                , {field: 'address', title: '采购地点', width: 100}
                , {field: 'priceamount', title: '采购总价', width: 100}
                , {fixed: 'right', title: '操作', width: 200, rowspan: 2, align: 'center', toolbar: '#probar2'} //这里的toolbar值是模板元素的选择器
            ]]
            , page: true //开启分页,
            , limit: 10
        });

        //监听工具条
        table.on('tool(profilter1)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('采购单编号：' + data.id + '<br>'
                    +'采购人：' + data.name + '<br>'
                    +'客户名称：' + data.name + '<br>'
                    +'采购时间：' + data.time + '<br>'
                    +'采购类型：' + data.type + '<br>'
                    +'采购数量：' + data.amount + '<br>'
                    +'采购单价：' + data.price + '<br>'
                    +'采购地点：' + data.address + '<br>'
                    +'采购总价：' + data.priceamount + '<br>');
            }  else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/procure/deleteProcureDTO",
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
