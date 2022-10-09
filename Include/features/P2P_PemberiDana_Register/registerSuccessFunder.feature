# @author name: Vriandy Rifianto Ralph
# @author email: 
# Feature Name : Register Success - Funder
# Generated : 06/10/2022
# Last modification: 09/10/2022

Feature: Register

  
  Scenario: Verify Register success funder
    
     Given User on P2P DEV login page
      And User click daftar disini
       
 
      And User click pemberi dana
        Then User on register page
      And User input nama lengkap
      And User input email
      And User input nomor handphone
      And User input password
      And User pilih jenis akun individual
      #And User input kode referral
      And User pilih tahu dari linkedin
      And User click lanjutkan
      And User click lanjutkan step two without accept TC
      And User accept TC
      And User access email to confirm the register
      And User scroll down the register email page
      And User confirm the register link
      And User login with new credentials
        Then User on funder dashboard page
      
      
      
      
      #Then User close the browser