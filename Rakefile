desc "Compile and test"
task :build => [:compile, :test]

CODE_DIRS = %w{ lexer symbols inter parser main }

desc "Compiles all Java code"
task :compile do
  CODE_DIRS.each do |dir|
    Dir["#{dir}/*.java"].each { |file| sh "javac #{file}" }
  end
end

desc "Tests all the test cases"
task :test do
  mkdir_p "tmp"
  Dir["tests/*.t"].each do |test_file|
    filename = File.basename(test_file, ".t")
    puts "====== " + filename + " ======"
    result = `java main.Main < #{test_file}`
    File.open("tmp/#{filename}.i", "wb") { |file| file << result.gsub(/\r\n|\r/, "\n") }
    sh "diff tests/#{filename}.i tmp/#{filename}.i"
  end
end

desc "Cleans everything"
task :clean do
  CODE_DIRS.each { |dir| Dir["#{dir}/*.class"].each { |file| rm file } }
end

task :default => :build
