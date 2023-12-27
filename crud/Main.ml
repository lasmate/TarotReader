(* Main.ml *)

open Yojson.Basic.Util

(*deprecated since parse_json now exists*)
let parse_json filename =
  let json = Yojson.Basic.from_file filename in
  let name = json |> member "name" |> to_string in
  let meanings = json |> member "meanings" |> to_string in
  let csv_data = [(name, meanings)] in
  let csv_file = open_out "output.csv" in
  Csv.output_all csv_file csv_data;
  close_out csv_file

