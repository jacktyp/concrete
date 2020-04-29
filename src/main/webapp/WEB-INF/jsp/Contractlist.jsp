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
    <script src="/layui/jquery.min.js"></script>
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
        <button type="button" onclick="addtest();" class="layui-btn layui-btn-sm"><i class="layui-icon layui-icon-add-1">录入合同</i></button>
    </div>
</script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/html" id="conbar2">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon layui-icon-about"></i>详情</a>
    <a class="layui-btn layui-btn-xs layui-bg-blue" lay-event="add"><i class="layui-icon layui-icon-add-circle"></i>添加通知</a>
    <a class="layui-btn layui-btn-xs layui-bg-orange" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script type="text/html" id="buttonTpl">
    {{#  if(d.remark == 1){ }}
    <button class="layui-btn layui-btn-xs">完成</button>
    {{#  } else { }}
    <button class="layui-btn layui-btn-primary layui-btn-xs">未完成</button>
    {{#  } }}
</script>
<script type="text/javascript">
    function addtest() {
        layer.open({
            title:'添加合同',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Contractadd',
            area: ['1000px', '600px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset:['10px', '20px']
        })
    }
</script>
<script>
    layui.use(['table'], function () {
        var table = layui.table;
        //展示已知数据
        table.render({
            elem: '#contractlist'
            ,url: 'http://localhost:8080/concrete/contract/findAllContractByState'
            ,toolbar: '#conbar1' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'print', 'exports']
            ,cols: [[ //标题栏
                {field: 'id', title: 'ID', width: 120, sort: true}
                , {field: 'name', title: '客户名称', width: 120}
                , {field: 'remark', title: '状态',templet: '#buttonTpl',width: 120}
                , {field: 'address', title: '送货地址', width: 120}
                , {field: 'amount', title: '混凝土需求量\m³', width: 160}
                , {field: 'price', title: '混凝土单价', width: 160}
                , {field: 'concretegrade', title: '混泥土等级', width: 120}
                , {field: 'time', title: '签订时间', width: 120}
                , {field: 'contact', title: '联系人', width: 120}
                , {field: 'telephone', title: '联系电话', width: 120}
                , {field: 'registrant', title: '合同登记人', width: 120}
                , {field: 'registranttime', title: '合同登记日期', width: 210}
                , {fixed: 'right',title: '操作', width: 320, align: 'center', toolbar: '#conbar2'} //这里的toolbar值是模板元素的选择器
            ]]
            ,page: true //开启分页
            ,even: true
        });

        //监听工具条
        table.on('tool(conteractlist)', function (obj) {
            var data = obj.data;//id name address amount price concretegrade time contact telephone remark registrant registranttime
            if (obj.event === 'detail') {
                layer.msg('合同编号：' + data.id + '<br>'
                    +'客户名称：' + data.name + '<br>'
                    +'地址：' + data.address + '<br>'
                    +'混凝土需求量：' + data.amount + '<br>'
                    +'混凝土价格：' + data.price + '<br>'
                    +'混泥土等级：' + data.concretegrade + '<br>'
                    +'合同签订时间：' + data.time + '<br>'
                    +'联系人：' + data.contact + '<br>'
                    +'联系电话：' + data.telephone + '<br>'
                    +'合同登记人：' + data.registrant + '<br>'
                    +'合同登记日期：' + data.registranttime);
            } else if (obj.event === 'add') {
                /*1、我给你传递、混凝土强度
                * 2、混凝土强度是否存在判断；存在了石头、沙子、水泥、添加剂、水*混凝土总量返回给我，*/
                layer.open({
                    title: '通知单制作',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Noticeadd',
                    area: ['1100px', '600px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['10px', '20px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#noticeadd").click();
                        othis.find('input[name="contractId"]').val(data.id);
                        othis.find('input[name="concreteamount"]').val(data.amount);
                        othis.find('input[name="mixproportionId"]').val(data.concretegrade);
                    }
                });
            } else if (obj.event === 'edit') {
                var tr = $(obj.tr);
                layer.open({
                    title: '合同修改',
                    type: 2,
                    content: 'http://localhost:8080/concrete/page/Contractmodify',
                    area: ['1000px', '600px'],
                    moveOut: true,
                    shade: [0.8, '#393D49'],
                    scrollbar: false,
                    offset: ['10px', '20px'],
                    success:function(layero, index){
                        var othis = layero.find('iframe').contents().find("#contractmodify").click();
                        othis.find('input[name="id"]').val(data.id);
                        othis.find('input[name="name"]').val(data.name);
                        othis.find('input[name="address"]').val(data.address);
                        othis.find('input[name="contact"]').val(data.contact);
                        othis.find('input[name="telephone"]').val(data.telephone);
                        othis.find('input[name="amount"]').val(data.amount);
                        othis.find('input[name="concretegrade"]').val(data.concretegrade);
                        othis.find('input[name="price"]').val(data.price);
                        othis.find('input[name="time"]').val(data.time);
                        othis.find('input[name="remark"]').val(data.remark);
                        othis.find('input[name="registrant"]').val(data.registrant);
                        othis.find('input[name="registranttime"]').val(data.registranttime);
                }
                });
            } else if (obj.event === 'del') {
                layer.confirm('真的删除么？', function (index) {
                    $.ajax({
                        url: "http://localhost:8080/concrete/contract/deleteContract",
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