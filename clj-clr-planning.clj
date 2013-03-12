;;; These are just some lines and functions to experiment with in a Clojure-CLR repl.

(System.Reflection.Assembly/LoadWithPartialName "System.Windows.Forms")

(System.Reflection.Assembly/LoadWithPartialName "System.DateTime")

(import '(System.Windows Window))
;(import '(System.DateTime))
;(import '(System.DateTime DateTime))

(new System.DateTime 2013 2 2)
(def dt1 (new System.DateTime 2013 1 1))

(DateTime/Compare dt1 dt2) ; static function access
(. dt1 CompareTo dt2) ; call instance method
(.CompareTo dt1 dt2) ; better instance method call

(System.Console/WriteLine "Hello World!")

(def ts (new TimeSpan 1 0 0))



(defn time-line
  "Returns a map representing a date-time-line.
  
  :type keyword
  
  Represents the type of the date-time-line.
  
  May have :earliest :latest
  "
  [type]
  {:type type})
  
(defn plan-strip 
  "Returns a plan-strip map.
  
  Will contain :type, :time-span.
   
  May contain :start, :end after it has been placed into a date-time-line."
  [type time-span]
  {:type type :time-span time-span})

(defn overlapping?
  "Returns the first plan-strip in time-line which overlaps with plan-strip-candidate or nil if there is no overlap."
  [time-line plan-strip-candidate]
  nil)
  
(defn search-fit-in 
  "Returns a plan-strip-candidate after finding a fitting position on time-line.
  The candidate will contain :start and :end datetimes."
  [time-line plan-strip start-at]
  (let [dt-now (DateTime/Now)
        plan-strip-candidate (assoc plan-strip :start dt-now :end (.Add dt-now (plan-strip :time-span)))]
  plan-strip-candidate))
  