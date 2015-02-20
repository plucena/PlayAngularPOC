create keyspace KunderaExamples;

CREATE COLUMN FAMILY Book
WITH comparator = UTF8Type
AND key_validation_class=UTF8Type
AND column_metadata = [
{column_name: id, validation_class: UTF8Type, index_type: KEYS}
{column_name: author, validation_class: UTF8Type, index_type: KEYS}
{column_name: title, validation_class: UTF8Type, index_type: KEYS}
{column_name: reader, validation_class: UTF8Type, index_type: KEYS}
{column_name: collection, validation_class: UTF8Type, index_type: KEYS}
{column_name: other, validation_class: UTF8Type}
];

set Book[0]['author'] = 'George Orwell';
set Book[0]['title'] = '1984';
set Book[0]['reader'] = 'plucena@gmail.com';
set Book[0]['collection'] = 'wish';
set Book[0]['other'] = '';

set Book[1]['author'] = 'Master Percival Lucena';
set Book[1]['title'] = 'Playing Play Framework with Cassandra';
set Book[1]['reader'] = 'mleonardi@ciandt.com';
set Book[1]['collection'] = 'wish';
set Book[1]['other'] = '';