const regText = document.querySelector('#reg-text');
const regWriter = document.querySelector('#reg-writer');

const btnClear = document.querySelector(".clear");
const btnReg = document.querySelector('.reg');
const btnPrioritys = document.querySelectorAll('input[name=reg-priority');
var selectedPriority = btnPrioritys[0];     //임시로 0번째 라디오버튼으로 초기화

const priorityLength = btnPrioritys.length;
for(var i = 0; i < priorityLength; i++){
     btnPrioritys[i].addEventListener('input', btnPrioritysOnClick);
}

function btnPrioritysOnClick(evt){
    selectedPriority = evt.target;
}

regText.addEventListener('input', function(evt){
    let value = evt.target.value;
    if(value.length > 24){
        window.alert("24자까지만 입력 가능합니다.");
        evt.target.value = value.substring(0, 24);
    }
});

btnClear.addEventListener('click', function(){
    
    regText.value = '';
    regWriter.value = '';
    selectedPriority.checked = true;
})

btnReg.addEventListener('click', function(){
    var oReq = new XMLHttpRequest();
    const regTextVal = regText.value;
    const regWriterVal = regWriter.value;
    const btnPriorityVal = selectedPriority;
    
    if(regTextVal === '' || regWriterVal === '' || btnPriorityVal === false){
        window.alert('빈칸을 채워주세요.');
    }else{

       var toDoObj = {
           "regText" : regTextVal,
           "regWriter" : regWriterVal,
           'selectedPriority' : btnPriorityVal
       }

       var ajax = function(toDoObj){
           
           if(!oReq){
               alert("XMLHttp인스턴스를 만들 지 못했습니다.");
               return false;
           }

           oReq.open('post', 'http://localhost:8080/todo/main');
           oReq.onreadystatechange = sendVal;
           oReq.setRequestHeader('Content-Type', 'application/x-www.form-urlencoded');
           oReq.send(toDoObj);
        }

        function sendVal(){
            if(oReq.readyState === XMLHttpRequest.DONE){
                if(oReq.status === 200){
                    console.log("통신성공했습니다.");
                }else{
                    console.log("통신실패.", oReq.status);
                }
            }else{
                console.log("아직 한발 남았다..", oReq.readyState);
            }
        }

        ajax;

    }

    console.log(regTextVal, regWriterVal, btnPriorityVal);

})