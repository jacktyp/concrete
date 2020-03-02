<%--
  Created by IntelliJ IDEA.
  User: 18438
  Date: 2020/1/27
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
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
<div class="layui-fluid" id="contractmodify">
    <form class="layui-form" action="/concrete/user1/addUser" method="post">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">ID</label>
                <div class="layui-input-block">
                    <input type="text" id="Contract_id" name="id" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="ID"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户名称</label>
                <div class="layui-input-block">
                    <input type="text" id="Contract_name" name="name" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="请输入"
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-item">
                <label class="layui-form-label">客户地址</label>
                <div class="layui-input-block">
                    <input type="text" id="Contract_address" name="address" lay-verify="required" lay-reqtext="地址，岂能为空？" autocomplete="off"
                           placeholder="请输入详细地址"
                           class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">联系人</label>
                <div class="layui-input-inline">
                    <input type="tel" id="Contract_contact" name="contact" lay-verify="required" lay-reqtext="联系人是必填项，岂能为空？"
                           autocomplete="off" placeholder="联系人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="tel" id="Contract_telephone" name="telephone" lay-verify="required|phone" autocomplete="off"
                           class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">请填写11位手机号码</div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">混凝土计划需求量</label>
                <div class="layui-input-inline">
                    <input type="text" id="Contract_amount" name="amount" lay-verify="required|number" autocomplete="off" placeholder="m³"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">混凝土强度等级</label>
                <div class="layui-input-inline">
                    <input type="text" id="Contract_concretegrade" name="concretegrade" lay-verify="title" autocomplete="off"
                           placeholder="如：A15、A20、C10、C15..."
                           class="layui-input">
                    <%--<select name="modules" lay-verify="required" lay-search="">
                        <option value="">直接选择或搜索选择</option>
                        <option value="1">A10</option>
                        <option value="2">A12</option>
                        <option value="3">A20</option>
                        <option value="5">C15</option>
                        <option value="6">C20</option>
                        <option value="7">C25</option>
                        <option value="8">C30</option>
                    </select>
                </div>--%>

                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">混凝土每立方价格</label>
                    <div class="layui-input-inline">
                        <input type="text" id="Contract_price" name="price" lay-verify="required|number" autocomplete="off" placeholder="¥ "
                               class="layui-input">
                    </div>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">合同签订日期</label>
                <div class="layui-input-inline">
                    <input type="text" id="Contract_time" name="time" lay-verify="date" class="layui-input test-item" id="test5"
                           placeholder="yyyy-MM-dd">
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea name="remark" id="Contract_remark" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">合同录入人</label>
                    <div class="layui-input-inline">
                        <input type="text" id="Contract_registrant" name="registrant" lay-verify="required" lay-reqtext="合同录入人是必填项，岂能为空？"
                               autocomplete="off"
                               placeholder="合同录入人姓名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">合同录入日期</label>
                    <div class="layui-input-inline">
                        <input type="text" id="Contract_registranttime" name="registranttime" lay-verify="date" class="layui-input test-item"
                               id="test6"
                               placeholder="yyyy-MM-dd HH:mm:ss">
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
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    var callbackdata = function () {
        var data = {
            resutl: true,
            resut2: $("#put1").val(),
            resut3: $("#put2").val(),
            resut3: $("#put3").val(),
            resut4: $("#put4").val(),
        };
        return data;
    };
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        //日期时间选择器
        laydate.render({
            elem: '#test5'
            , eventElem: '#test5-1'
            , trigger: 'click'
        });
        //日期时间选择器
        laydate.render({
            elem: '#test6'
            , eventElem: '#test6-1'
            , trigger: 'click'
        });
    });
</script>

</body>
</html>