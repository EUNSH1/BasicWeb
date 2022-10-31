console.log("memberAdd");

$("#all").click(function(){
    let ch = $(this).prop("checked");
    console.log("ch : " , ch);

    $(".check").prop("checked",ch);
})
$(".check").click(function(){
    
    //let flag = false;
    $("#all").prop("checked",true);

    $(".check").each(function(idx, item){
        let ch = $(item).prop("checked");       
        if(!ch){
            //flag=false;
            $("#all").prop("checked",false);
            console.log(ch);
            return false;

        }
        console.log("ch : ",ch);
    });
   
    //$("#all").prop("checked",flag);
});

//id, pw, pwEquals, name, email
let results = [false, false, false, false, false];

//Id Check
$("#ipId").blur(function(){
    console.log("start");
    let id = $("#ipId").val();
    let result = nullCheck(id,$("#inputIdResult"),"ID");
    results[0]=result;
    console.log(result);

    $.get("./idCheck?id="+id,function(data){
        console.log("Data : ",data);
        if(data == '0') {
            $("#inputIdResult").html("사용가능한 ID");
            results[0]=true;
        }else{
            $("#inputIdResult").html("이미 사용중인 ID");
            results[0]=false;
        }
    })
});

//pw Check
// $("pw").blur(function(){
//     let result = nullCheck($("#pw").val(),$("#inputPwResult"),"PW");
//     results[1]=result;
// });

// $("#pw").change(function(){
//     $("#inputPwCheck").val("");
//     results[2]=false;
//     $("#inputPwCheckResult").html("");
// });

$("#ipPw").on({
    blur:function(){
        let result = nullCheck($("#ipPw").val(), $("#inputPwResult"),"PW");
        results[1]=result;

    },
    change:function(){
        $("inputPwCheck").val("");
        results[2]=false;
        $("#inputPwCheckResult").html("");
    }
});

//// pw Equal Check
$("#inputPwCheck").blur(function(){
    let result = equals($("#ipPw").val(), $("#inputPwCheck").val());
    if(result){
        $("#inputPwCheckResult").html("정상");
    }else{
        $("#inputPwCheckResult").html("PW가 틀립니다");
    }
    results[2]=result;
})

//name Check
$("#name").blur(function(){
    let result = nullCheck($("#name").val(), $("#inputNameResult"), "Name");
    results[3]=result;
})

//email check
$("#email").blur(function(){
    let result = nullCheck($("#email").val(), $("#inputEmailResult"), "Email");
    results[4]=result;
})




$("#joinButton").click(function(){
    //event 강제 실행

    if(results.includes(false)){
        swal("필수 입력은 다 입력해");
    }else{
        swal("전송");
        // $("#joinForm").submit();
    }

})

$("#test").click(function(){
    let id=1234;
    let name=it;

    $.post("test",{
        //파라미터이름:변수명
        //{"키 : 벨류"}
        id:id,
        name:name
    },function(result){
        console.log("result : ",result);
        console.log("name : ",result.name);
    })
})

$("#test2").click(function(){
    let id = "abcd";
    $.ajax({
        type:"GET",
        url:"idCheck",
        data:{
            id:id
        },
        success:function(data){
            console.log("Data : ",data);
        },
        error:function(xhr,status,error){
            console.log("Xhr : ",xhr);
            console.log("Status : ",status);
            console.log("Error : ",error);


        }
    })
})

$("#test3").click(function(){
    let id = "1234";
    let name = "iu";
    let ar = [1,2,3];
    $.ajax({
        type:"POST",
        url:"test",
        traditional:true,
        data:{
            id:id,
            name:name,
            ar:ar
        },
        success:function(result){
            console.log("result : ",result);
        }
    })
})

let count = 3;
$("#s1Add").click(function(){
    let add = '<option class ="abc" id="adbc'+count+'">'+count+'</option>';
    $("#s1").append(add);
    count++;

   // $("#slAdd").remove();
})

// $("#s1").click(function(){
//     $("#s1").empty();
// })