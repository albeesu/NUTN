<html>
<meta charset="UTF-8">
<title>bigdata_task2</title>
<center>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<form  action="hidden.php" method="POST" name="theform">
<input type="radio" name="task" value="Query.php">第一題
<input type="radio" name="task" value="Query2.php">第二題
<input type="radio" name="task" value="Query3.php">第三題 
<input type="radio" name="task" value="Query4.php">第四題 
<input type="radio" name="task" value="Query5.php">第五題 
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

