<html>
<meta charset="UTF-8">
<title>bigdata_task2</title>
<center>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<form  action="chart2total.php" method="POST" name="theform">
<input type="radio" name="task" value="chart2_total.php">總月報表
<input type="radio" name="task" value="chart2_total2.php">總季報表
<input type="radio" name="task" value="chart2.php">教育娛樂
<input type="radio" name="task" value="chart2_2.php">服飾用品
<input type="radio" name="task" value="chart2_3.php">美妝保健 
<input type="radio" name="task" value="chart2_4.php">其他 
<input type="radio" name="task" value="chart2_5.php">電器用品 
<input type="radio" name="task" value="chart2_6.php">生活百貨
<input type="radio" name="task" value="chart2_7.php">食品飲料

<input type="submit" value="提交" />
</form>

<div id="yoman"></div>
<?php
if (!empty($_POST['task'])) {
$task=$_POST['task'];
//echo "var task='$task'";
}
?>
<script>
$.ajax({
    url: <?php echo "'$task'"; ?>,
    type: 'GET',
    success: function(data) {
    console.log(data);
    $("#yoman").html(data);
    },
  });
 </script>

</html>

