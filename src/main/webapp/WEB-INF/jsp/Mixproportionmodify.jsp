<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/3/1
  Time: 14:00
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
<div class="layui-fluid" id="mixmodify">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">实验编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="id" lay-verify="title" autocomplete="off" placeholder="ID"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">实验名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="实验名称"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                <label class="layui-form-label">混凝土强度等级</label>
                <div class="layui-input-inline">
                    <input type="text" name="concretegrade" lay-verify="title" autocomplete="off"
                           placeholder="如：A15、A20、C10、C15..."
                           class="layui-input">
                </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">强度对应配合比</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mp" lay-verify="title" autocomplete="off" placeholder="1：1：0.9：0.2"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <%--<div class="layui-form-item">
                    <label class="layui-form-label">实验状态</label>
                    <div class="layui-input-inline">
                        <select name="state" lay-verify="required" lay-search="">
                            <option value="0">合格</option>
                            <option value="1">不合格</option>
                        </select>
                    </div>
                </div>--%>
                <div class="layui-inline">
                    <label class="layui-form-label">实验状态</label>
                    <div class="layui-input-inline">
                        <input type="text" name="state" lay-verify="title" autocomplete="off" placeholder="请填写0/1"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验石头需求量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="stone" lay-verify="title" autocomplete="off" placeholder="m³"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验沙子需求量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sand" lay-verify="title" autocomplete="off" placeholder="m³"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验水泥需求量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="cement" lay-verify="title" autocomplete="off" placeholder="m³"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验水需求量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="water" lay-verify="title" autocomplete="off" placeholder="m³"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验添加剂需求量</label>
                    <div class="layui-input-inline">
                        <input type="text" name="additive" lay-verify="title" autocomplete="off" placeholder="m³"
                               class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">实验备注</label>
                <div class="layui-input-block">
                    <input type="text" name="remark" lay-verify="title" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">实验人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="experiment" lay-verify="title" autocomplete="off" placeholder="录入人姓名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实验日期</label>
                    <div class="layui-input-inline">
                        <input type="text" name="experimenttime" class="layui-input test-item" id="test6"
                               placeholder="yyyy-MM-dd">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;
        form.render();
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
//监听提交
        form.on('submit(demo1)', function(data){
            //layer.msg(JSON.stringify(data.field));
            console.log(data.field);
            $.ajax({
                url: "http://localhost:8080/concrete/mixproportion/updateMixproportion",
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
