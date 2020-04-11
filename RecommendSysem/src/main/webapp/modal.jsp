<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap实例-添加兴趣标签</title>

    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .div1{text-align:center}
        .btn{margin-right: 4px}
    </style>
</head>
<body>

<h2>模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    打开模态框
</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加兴趣标签
                </h4>
            </div>
            <div class="modal-body">
                <div class="div1" id="div1">
                    <button type="button" class="btn btn-info btn-xs" id="btn1" onclick="add(this);">特征1 +</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn3" onclick="add(this);">特征3</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn5" onclick="add(this);">特征5</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn6" onclick="add(this);">特征6</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn7" onclick="add(this);">特征7</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn8" onclick="add(this);">特征8</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn9" onclick="add(this);">特征9</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn10" onclick="add(this);">特征10</button>
                    <br></br>
                    <button type="button" class="btn btn-info btn-xs" id="btn11" onclick="add(this);">特征11</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn12" onclick="add(this);">特征12</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn13" onclick="add(this);">特征13</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn14" onclick="add(this);">特征14</button>
                    <button type="button" class="btn btn-info btn-xs" id="btn15" onclick="add(this);">特征15</button>
                </div>
                <hr></hr>
                <div class="div1" id="div2">
                    <button type="button" class="btn btn-success btn-xs" id="btn2" onclick="remove(this);">特征2 -</button>
                    <button type="button" class="btn btn-success btn-xs" id="btn4"  onclick="remove(this);">特征4 -</button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script>

    function add(value){
        var btn = $(value).attr("id");
        var str = '#'+btn;
        var btnx = document.querySelector(str);
        $("#div2").append(btnx);
        $(str).removeAttr("onclick");
        $(str).attr("onclick","remove(this);");
        $(str).removeAttr("class","btn btn-info btn-xs");
        $(str).attr("class","btn btn-success btn-xs");

        equal5();
    }

    function remove(value){
        var btn = $(value).attr("id");
        var str = '#'+btn;
        var btnx = document.querySelector(str);

        $("#div1").append(btnx);
        $(str).removeAttr("class","btn btn-success btn-xs");
        $(str).attr("class","btn btn-info btn-xs");
        $(str).removeAttr("onclick");
        $(str).attr("onclick","add(this);");

        notEqual5();
    }

    function equal5(){
        var button = document.querySelectorAll('#div2 button');
        if(button.length==5){
            $(".btn-info").removeAttr("onclick");
        }
    }

    function notEqual5(){
        var button = document.querySelectorAll('#div2 button');
        if(button.length!=5){
            $(".btn-info").removeAttr("onclick");
            $(".btn-info").attr("onclick","add(this);");
        }
    }

</script>

</body>
</html>