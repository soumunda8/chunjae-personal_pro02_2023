function plusProduct(cnt){
    var num = +$("#productNum"+cnt).val() + 1;
    $("#productNum"+cnt).val(num);
}

function minusProduct(cnt){
    var num = +$("#productNum"+cnt).val() - 1;
    if(num < 0) {num = 0;}
    $("#productNum"+cnt).val(num);
}

function addCart(path, cnt) {
    var prono = $("#proNo").val();
    var amount = $("#productNum"+cnt).val();
    if(!confirm("장바구니에 담으시겠습니까?")) {
        return false;
    }
    if(amount == 0){
        alert("상품 수량이 0입니다.");
        return false;
    }
    addCartPro(prono, amount, path);
}

function updateCart(originAmount, prono, path, cnt) {
    var canAmount = $("#canAmount"+cnt).val();
    var amount = $("#productNum"+cnt).val();
    if(!confirm("장바구니 수량을 변경하시겠습니까?")) {
        return false;
    }
    if(originAmount === amount) {
        return false;
    }
    amount = amount - originAmount;
    if(originAmount + amount > canAmount) {
        $("#msg"+cnt).html("해당 상품의 구입 가능한 수량은 " + canAmount + "개이므로 구입 불가합니다. 구입 수량을 변경하세요.");
        return false;
    } else {
        $("#msg"+cnt).css("display", "none");
    }

    if(originAmount + amount > 0) {
        addCartPro(prono, amount, path);
    } else {
        removeCart(prono, path);
    }
}

function addCartPro(prono, amount, path){
    $.ajax({
        url:"/pro02/addCartPro.do",
        type:"post",
        data : { "prono":prono, "amount":amount },
        dataType:"json",
        success:function(data){
            var idPass = data.result;
            if(confirm("장바구니로 이동하시겠습니까?")) {
                location.href = path + "/listCart.do";
            }
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            /*if(request.status == 200) {
                $('#cartModal').modal('hide');
            } else {
                alert("장바구니를 확인해 주세요.");
                $('#cartModal').modal('hide');
            }*/
            location.href = path + "/listCart.do";
        }
    });
}

function removeCart(prono, path){
    $.ajax({
        url: path + "/removeCartPro.do",
        type:"post",
        data : { "prono":prono },
        dataType:"json",
        success:function(data){
            var idPass = data.result;
            //alert("성공");
        },
        error:function(request,status,error){
            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}

function findAddr(){
    new daum.Postcode({
        oncomplete:function(data){
            var roadAddr = data.roadAddress;
            var jibunAddr = data.jibunAddress;
            document.getElementById("postcode").value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("address1").value = roadAddr;
            } else if(jibunAddr !== ''){
                document.getElementById("address1").value = jibunAddr;
            }
            document.getElementById("address2").focus();
        }
    }).open();
}