let newRows=function(r,c){
    //获取表格对象
    let dtab=document.getElementById("dataTable");
    //获取表格的行对象
    let rows=dtab.rows;
    
    for(let i=0;i<r;i++)
    {
   	//向表格插入行
        let newRow=dtab.insertRow(rows.length);
   	 for(let j=0;j<c;j++)
   	 {
   		 newRow.insertCell(j);
   	 }
    }

	
}