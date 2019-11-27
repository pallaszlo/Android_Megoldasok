<?php

	 include 'config.inc.php';
	 
	 $data = json_decode( file_get_contents( 'php://input' ), true );
	 
	 // Check whether username or password is set from android	
     //if(isset($_POST['username']) && isset($_POST['password']))
	 if(isset($data['username']) && isset($data['password']))
     {
		  // Innitialize Variable
		  $result='';
	   	  $username = $data['username'];
          $password = $data['password'];
		  
		  // Query database for row exist or not
          $sql = 'SELECT * FROM tbl_login WHERE  email = :username AND password = :password';
          $stmt = $conn->prepare($sql);
          $stmt->bindParam(':username', $username, PDO::PARAM_STR);
          $stmt->bindParam(':password', $password, PDO::PARAM_STR);
          $stmt->execute();
          if($stmt->rowCount())
          {
			$response = array(
				'status' => 'success',
				'data' => $username ."  ".$password
			); 	
          }  
          elseif(!$stmt->rowCount()){
			$response = array(
				'status' => 'error',
				'data' => $username ."  ".$password
			); 	
          }		  
		  // send result back to android
   		  header('Content-Type: application/json');
		  echo json_encode($response); 
		  //echo $response;
  	}
	
?>