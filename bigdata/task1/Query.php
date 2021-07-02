<?php 
	//error_reporting(E_ALL^E_NOTICE^E_WARNING);//把錯誤關閉
	$link = mysqli_connect( 
					'localhost',  // MySQL主機名稱 
					'root',       // 使用者名稱 
					'',  // 密碼
					'bigdata');  // 預設使用的資料庫名稱
	
	mysqli_query($link,"SET CHARACTER SET UTF8");
	$sql="SELECT 
				sex.sex_name,
				consum_cat.consum_type,
				COUNT(*),
				SUM(fact.quantity),
    			SUM(fact.amount)

	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
				
		  GROUP BY 
				sex.sex_name,
				consum_cat.consum_type
			"
			
			;
				

	$result=mysqli_query($link,$sql)
?>
<html>
<center>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf8">
	<title>bigdata</title>
	<h2 align=center>巨量資料分析</h2><hr>
</head>
<body>
    <table  border='1'>
	<tr>
		<td><center>性別</td>
		<td><center>消費種類</td>
		<td><center>消費筆數</td>
		<td><center>訂購量</td>
		<td><center>金額</td>

  </tr>
	<?php
	
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
        echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
		echo '<td><center>'.$rs[1].'</td>';
		echo '<td><center>'.$rs[2].'</td>';
        echo '<td><center>'.$rs[3].'</td>';
        echo '<td><center>'.$rs[4].'</td>';
		
    	  echo '</tr>';
  	   }
    ?>
	</table>
	</body>
</html>

