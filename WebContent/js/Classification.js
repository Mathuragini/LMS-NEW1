$(document).ready(function(){
	fetch_classification();
	$("#ClassificationForm").submit(function(event){
		event.preventDefault();
		console.log($("#ClassificationForm").serialize());
		$.ajax({
			url:'ClassificationController',
		type:'post',
		data:$("#ClassificationForm").serialize(),
		success:function(data){
			alert(data);
		}
		
		});
		
		$("#myModel").modal('toggle');
		return false;
	});
		
		$(document).on("click",".editaction",function(){
			alert($(this).attr("data-id"))
		});
		
		$(document).on("click",".deleteaction",function(){
			alert($(this).attr("data-id"))
		});
		
		
		function fetch_classification(){
			$.ajax({
				url:'ClassificationController',
		        type:'get',
		        success:function(datas){
		        	//console.log(datas);
		        	$.each(datas.classification,function(key,classificationList){
		        		console.log(datas.classification);
		        		var row=` <tr>
		        		    <td>${classificationList.classificationId}</td>
		        		    <td>${classificationList.classificationName}</td>
		        		    <td><button class='btn btn-warning btn-small editaction' data-id='${classificationList.classificationId}'>Edit</button></td>
		        		    <td><button class='btn btn-danger btn-small deleteaction' data-id='${classificationList.classificationId}'>Delete</button></td>
		        		    </tr>`;
		        		$("#classificationTable tbody").append(row);
		        	})
		        }
			});
		}
	});
