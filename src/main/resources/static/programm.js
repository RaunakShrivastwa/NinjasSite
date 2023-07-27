function Programm(){
  const data=  document.querySelector('#program').value;
   if(data=='java' || data=='JAVA' || data=='core java' || data=="java programming" || data=="java course"){
      window.location='/java';
   }
   else{
      alert("nothing")
   }
}