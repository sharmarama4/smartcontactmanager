console.log("This is my first script file");
const toggleSidebar=()=>{
    if($('.sidebar').is(":visible")){
        //true
        //banda karna hai
        $(".sidebar").css("display","none");
        $(".content").css("margin-left","0%");
    }else{
        //false
        //show karna hai
        $(".sidebar").css("display","block");
        $(".content").css("margin-left","20%");
    }
};