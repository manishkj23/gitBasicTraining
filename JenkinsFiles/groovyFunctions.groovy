def extractTotalScenarios(String pattern){
    def res = s =~ /\b([A-Z]{4}):[^\]\[\d]*(\d{1,5})\b/
    if (res.find()) {
        println "${res[0][1]}, ${res[0][2]}"
    } else {
        println "not found"
    }
}

return this;