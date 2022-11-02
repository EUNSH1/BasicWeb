

$("#uploadButton").click(function(){
    if($("#title").val() != ""){
        results[0] =true;
    }

    if($("#writer").val() != ""){
        results[1] =true;
    }

    if($("#contents").val() != ""){
        results[2] =true;
    }
    swal({
        title: "작성하시겠습니까?",
        buttons: true,
        dangerMode: true,
      })
      .then((willDelete) => {
        
        if (willDelete) {
            if(results.includes(false)){
                swal("입력 되지 않은 값이 있습니다.","","warning")
            }else{
                swal("작성 완료했습니다.", {
                    icon: "success",
                    
                  }).then(function(){
                    $("#frm").submit();
                  })
            }
          
        } else {
          swal("취소하였습니다.");
        }
      });
})





// 글제목,작성자, 글내용
let results = [false, false, false];
