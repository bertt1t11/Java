
puts  "Enter name of file to compile "
fName = gets

JSrc = "javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml " + fName
puts "You Entered: #{JSrc}"

exec(JSrc)
