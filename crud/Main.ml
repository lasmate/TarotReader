(* Main.ml *)

open Yojson.Basic.Util

(*
  [parse_json filename] is a function that parses a JSON file and extracts the "name" and "meanings" fields.
  It then writes the extracted data to a CSV file named "output.csv".

  - [filename] is the path to the JSON file to be parsed.

  Example usage:
  ```
  parse_json "input.json"
  ```

  This function does not return any value.
*)
let parse_json filename =
  let json = Yojson.Basic.from_file filename in
  let name = json |> member "name" |> to_string in
  let meanings = json |> member "meanings" |> to_string in
  let csv_data = [(name, meanings)] in
  let csv_file = open_out "output.csv" in
  Csv.output_all csv_file csv_data;
  close_out csv_file

