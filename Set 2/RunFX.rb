puts  "Enter name of file to run "
fName = gets

JSrc = "java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml " + fName
puts "You Entered: #{JSrc}"

exec(JSrc)
