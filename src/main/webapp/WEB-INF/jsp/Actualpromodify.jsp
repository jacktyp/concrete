<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/2/27
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>搅拌站业务流程系统</title>
    <meta name="renderer" content="webkit">
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layui/style/admin.css">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script src="/layui/layui.all.js" charset="utf-8"></script>
</head>
<body>
<div class="layui-fluid" id="actualpromodify">
    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实际生产编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="id" lay-verify="title" autocomplete="off" placeholder=""
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">计划生产编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="scheduleId" lay-verify="title" autocomplete="off" placeholder=""
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">通知单编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="notificationId" lay-verify="title" autocomplete="off" placeholder=""
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">合同编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="contractId" lay-verify="title" autocomplete="off" placeholder=""
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实际生产混凝土使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="concreteamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产石头使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="stoneamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产沙子使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="sandamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产水泥使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="cementamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产水使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="wateramount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产添加剂使用总量</label>
                <div class="layui-input-inline">
                    <input type="text" name="additiveamount" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实际生产的时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="time" lay-verify="title" autocomplete="off" placeholder="请填写分钟数"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产开始时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="productiontime" lay-verify="title" autocomplete="off" id="test5"
                           placeholder="yyyy-MM-dd"
                           class="layui-input">
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">实际生产结束时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="endtiime" lay-verify="title" autocomplete="off" id="test6"
                               placeholder="yyyy-MM-dd"
                               class="layui-input">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实际生产添加人</label>
                <div class="layui-input-inline">
                    <input type="text" name="registrant" lay-verify="title" autocomplete="off" placeholder="录入人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实际生产添加日期</label>
                <div class="layui-input-inline">
                    <input type="text" name="registranttime" class="layui-input test-item" id="test7"
                           placeholder="yyyy-MM-dd">
                </div>
            </div>
        </div>

  <%--      <div class="layui-form-item">
            <label class="layui-form-label">实际生产车辆信息添加</label>
            &lt;%&ndash;<div class="layui-input-block">
                <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>&ndash;%&gt;
            <button type="button" onclick="addtest();" class="layui-btn layui-btn-normal layui-btn-lg layui-btn-radius">
                运输单添加
            </button>

        </div>--%>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<%--<script type="text/javascript">
    function addtest() {
        layer.open({
            title: '添加运输单',
            type: 2,
            content: 'http://localhost:8080/concrete/page/Transportationadd',
            area: ['1000px', '500px'],
            moveOut: true,
            shade: [0.8, '#393D49'],
            scrollbar: false,
            offset: 'lt'
        })

    }
</script>--%>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            , eventElem: '#test5-1'
            , trigger: 'click'
            //,lang: 'en'
        });
//日期时间选择器
        laydate.render({
            elem: '#test6'
            , eventElem: '#test6-1'
            , trigger: 'click'
            //,lang: 'en'
        });
        //日期时间选择器
        laydate.render({
            elem: '#test7'
            , eventElem: '#test7-1'
            , trigger: 'click'
            //,lang: 'en'
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            //layer.msg(JSON.stringify(data.field));
            console.log(data.field);
            $.ajax({
                url: "http://localhost:8080/concrete/actualpro/updateActualproDTO",
                type: "POST",
                data: data.field,
                success: function (msg) {
                    if (msg != null) {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        window.parent.location.reload();
                    } else {
                        layer.msg("修改失败", {icon: 5});
                    }
                }
            });
            return false;
        });

    });
</script>
</html>