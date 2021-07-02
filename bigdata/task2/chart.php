<?php 
	//error_reporting(E_ALL^E_NOTICE^E_WARNING);//把錯誤關閉
	$link = mysqli_connect( 
					'localhost',  // MySQL主機名稱 
					'root',       // 使用者名稱 
					'',  // 密碼
					'bigdata');  // 預設使用的資料庫名稱
	
	mysqli_query($link,"SET CHARACTER SET UTF8");
	$sql="(SELECT 
				age.age_category,
				income.income_id,
				income.income_category,
				SUM(income.income_id),
				COUNT(*),
				SUM(income.income_id)/COUNT(*)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				age.age_category='20~29')
		UNION
		(SELECT 
				age.age_category,
				income.income_id,
				income.income_category,
				SUM(income.income_id),
				COUNT(*),
				SUM(income.income_id)/COUNT(*)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				age.age_category='30~39')
				
		UNION
		(SELECT 
				age.age_category,
				income.income_id,
				income.income_category,
				SUM(income.income_id),
				COUNT(*),
				SUM(income.income_id)/COUNT(*)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				age.age_category='40~49')
				
				UNION
		(SELECT 
				age.age_category,
				income.income_id,
				income.income_category,
				SUM(income.income_id),
				COUNT(*),
				SUM(income.income_id)/COUNT(*)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				age.age_category='50~59')
				
				UNION
		(SELECT 
				age.age_category,
				income.income_id,
				income.income_category,
				SUM(income.income_id),
				COUNT(*),
				SUM(income.income_id)/COUNT(*)
	      FROM 
	      		fact 
				LEFT JOIN sex ON sex.sex_id = fact.sex_id
				LEFT JOIN income ON income.income_id = fact.income_id
				LEFT JOIN location ON location.location_id = fact.location_id
				LEFT JOIN date ON date.date_id = fact.date_id
				LEFT JOIN consum_cat ON consum_cat.consum_id = fact.cosume_id
				LEFT JOIN pay ON pay.pay_id = fact.pay_id
				LEFT JOIN age ON age.age_id = fact.age_id
		  WHERE
				age.age_category='60~69')
		
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
	平均年收入數字代表範圍=> 1:0~30萬，2:30~50萬，3:50~70萬，4:70萬以上
    <table  border='1'>
	<tr>
		<td><center>年齡</td>
		<td><center>人數</td>
		<td><center>平均年收入</td>


  </tr>
	<?php
	$income=array();
    for($i=1;$i<=mysqli_num_rows($result);$i++)
       {
        $rs=mysqli_fetch_row($result);
        echo '<tr>';
        echo '<td><center>'.$rs[0].'</td>';
		echo '<td><center>'.$rs[4].'</td>';
		echo '<td><center>'.$rs[5].'</td>';

		$income[$i]=$rs[5];
    	  echo '</tr>';
  	   }
    ?>
	</table>
	</body>
</html>


<canvas id="myChart" style="height:200px; width:1000px"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script>
var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',

    // The data for our dataset
    data: {
        labels: ['20~29歲', '30~39歲', '40~49歲', '50~59歲', '60~69歲'],
        datasets: [{
            label: '年收入',
            //backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data:[ <?PHP echo "$income[1],$income[2],$income[3],$income[4],$income[5]"; ?>]
        }]
    },

    // Configuration options go here
    options: {}
});
</script>