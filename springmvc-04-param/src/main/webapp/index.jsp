<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<h2>测试数组传参</h2>
	<form action="${pageContext.request.contextPath}/complex/array" method="post">
		爱好: <input type="checkbox"  name="hobby" value="足球"/>足球
		<input type="checkbox"  name="hobby" value="篮球"/>篮球
		<input type="checkbox"  name="hobby" value="羽毛器"/>羽毛器
		<input type="checkbox"  name="hobby" value="排球"/>排球
		<br />
		<input type="submit" value="测试数组传参">
	</form>
	<hr />
	
	<h2>测试List传参</h2>
	<form action="${pageContext.request.contextPath}/complex/list" method="post">
		爱好: <input type="checkbox"  name="hobbyList" value="音乐"/>音乐
		<input type="checkbox"  name="hobbyList" value="篮球"/>篮球
		<input type="checkbox"  name="hobbyList" value="羽毛器"/>羽毛器
		<input type="checkbox"  name="hobbyList" value="排球"/>排球
		<br />                            
		<input type="submit" value="测试List传参">
	</form>
	<hr />
	<button id="testMap" type="button">测试Map</button>
	<h2>测试Json转Map</h2>
	<button type="button" onclick="jsonToMap()">测试Json转Map</button>
	<hr />
	<button type="button" onclick="jsonTolist()">测试jsonToList</button>
	<hr />
	<button type="button" onclick="jsonTobean()">测试jsonTobean</button>
	
	
	
	
	<script src="${pageContext.request.contextPath}/static/js/jquery-1.10.2.js"></script>
	<script type="text/javascript">
		const path="${pageContext.request.contextPath}"
		$(function () {
		
			$('#testMap').click(function () {
				$.ajax({
					url:path+'/complex/map',
					type:'post',
					dataType:'text',
					data:"stuMap['id']=1&stuMap['name']=etoak",
					success:function(data){
						alert(data);
					}
				
					
				})
			});
		})
		
		function jsonToMap() {
			let obj = {id : 1,
					name:'lala'};
			$.ajax({
				url:path+'/json/jsonTomap',
				type:'post',
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				data:JSON.stringify(obj),//将json对象转成json字符串
				success:function(data){
					alert(data.msg);
				}
			})
		}
		
		//jsonTolist
		function jsonTolist() {
			let array =[{id:2,name:'李四',age:25}];
			let user={id:1,name:'张三',age:20};
			array.push(user)
			
			$.ajax({
				url:path+'/json/jsonTolist',
				type:'post',
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				data:JSON.stringify(array),
				success:function(data){
					alert(data.msg+' - '+data.code);
				}		
			})
		}
		//jsonTobean
		function jsonTobean() {
			let obj ={id:1,
					name:'popo',
					age:25,
					hobbyList:['看书','听音乐'],
					stuMap:{id:2,score:99}
			};
			$.ajax({
				url:path+'/json/jsonTobean',
				type:'post',
				dataType:'json',
				contentType:'application/json;charset=utf-8',
				data:JSON.stringify(obj),
				success:function(data){
					alert(data.msg+' ~~~~  '+data.code);
				}					
			});
			
			
		}
		
		
		
	</script>
	
</body>
</html>