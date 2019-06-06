// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.test01;

/**
 * Protobuf type {@code com.test01.StudentResponseList}
 */
public  final class StudentResponseList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.test01.StudentResponseList)
    StudentResponseListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StudentResponseList.newBuilder() to construct.
  private StudentResponseList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StudentResponseList() {
    studentResponse_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StudentResponseList(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              studentResponse_ = new java.util.ArrayList<com.test01.StudentResponse>();
              mutable_bitField0_ |= 0x00000001;
            }
            studentResponse_.add(
                input.readMessage(com.test01.StudentResponse.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        studentResponse_ = java.util.Collections.unmodifiableList(studentResponse_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.test01.StudentProto.internal_static_com_test01_StudentResponseList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.test01.StudentProto.internal_static_com_test01_StudentResponseList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.test01.StudentResponseList.class, com.test01.StudentResponseList.Builder.class);
  }

  public static final int STUDENTRESPONSE_FIELD_NUMBER = 1;
  private java.util.List<com.test01.StudentResponse> studentResponse_;
  /**
   * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
   */
  public java.util.List<com.test01.StudentResponse> getStudentResponseList() {
    return studentResponse_;
  }
  /**
   * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
   */
  public java.util.List<? extends com.test01.StudentResponseOrBuilder> 
      getStudentResponseOrBuilderList() {
    return studentResponse_;
  }
  /**
   * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
   */
  public int getStudentResponseCount() {
    return studentResponse_.size();
  }
  /**
   * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
   */
  public com.test01.StudentResponse getStudentResponse(int index) {
    return studentResponse_.get(index);
  }
  /**
   * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
   */
  public com.test01.StudentResponseOrBuilder getStudentResponseOrBuilder(
      int index) {
    return studentResponse_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < studentResponse_.size(); i++) {
      output.writeMessage(1, studentResponse_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < studentResponse_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, studentResponse_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.test01.StudentResponseList)) {
      return super.equals(obj);
    }
    com.test01.StudentResponseList other = (com.test01.StudentResponseList) obj;

    if (!getStudentResponseList()
        .equals(other.getStudentResponseList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getStudentResponseCount() > 0) {
      hash = (37 * hash) + STUDENTRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getStudentResponseList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.test01.StudentResponseList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.test01.StudentResponseList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.test01.StudentResponseList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.test01.StudentResponseList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.test01.StudentResponseList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.test01.StudentResponseList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.test01.StudentResponseList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.test01.StudentResponseList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.test01.StudentResponseList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.test01.StudentResponseList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.test01.StudentResponseList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.test01.StudentResponseList parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.test01.StudentResponseList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.test01.StudentResponseList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.test01.StudentResponseList)
      com.test01.StudentResponseListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.test01.StudentProto.internal_static_com_test01_StudentResponseList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.test01.StudentProto.internal_static_com_test01_StudentResponseList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.test01.StudentResponseList.class, com.test01.StudentResponseList.Builder.class);
    }

    // Construct using com.test01.StudentResponseList.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getStudentResponseFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (studentResponseBuilder_ == null) {
        studentResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        studentResponseBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.test01.StudentProto.internal_static_com_test01_StudentResponseList_descriptor;
    }

    @java.lang.Override
    public com.test01.StudentResponseList getDefaultInstanceForType() {
      return com.test01.StudentResponseList.getDefaultInstance();
    }

    @java.lang.Override
    public com.test01.StudentResponseList build() {
      com.test01.StudentResponseList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.test01.StudentResponseList buildPartial() {
      com.test01.StudentResponseList result = new com.test01.StudentResponseList(this);
      int from_bitField0_ = bitField0_;
      if (studentResponseBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          studentResponse_ = java.util.Collections.unmodifiableList(studentResponse_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.studentResponse_ = studentResponse_;
      } else {
        result.studentResponse_ = studentResponseBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.test01.StudentResponseList) {
        return mergeFrom((com.test01.StudentResponseList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.test01.StudentResponseList other) {
      if (other == com.test01.StudentResponseList.getDefaultInstance()) return this;
      if (studentResponseBuilder_ == null) {
        if (!other.studentResponse_.isEmpty()) {
          if (studentResponse_.isEmpty()) {
            studentResponse_ = other.studentResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureStudentResponseIsMutable();
            studentResponse_.addAll(other.studentResponse_);
          }
          onChanged();
        }
      } else {
        if (!other.studentResponse_.isEmpty()) {
          if (studentResponseBuilder_.isEmpty()) {
            studentResponseBuilder_.dispose();
            studentResponseBuilder_ = null;
            studentResponse_ = other.studentResponse_;
            bitField0_ = (bitField0_ & ~0x00000001);
            studentResponseBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getStudentResponseFieldBuilder() : null;
          } else {
            studentResponseBuilder_.addAllMessages(other.studentResponse_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.test01.StudentResponseList parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.test01.StudentResponseList) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.test01.StudentResponse> studentResponse_ =
      java.util.Collections.emptyList();
    private void ensureStudentResponseIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        studentResponse_ = new java.util.ArrayList<com.test01.StudentResponse>(studentResponse_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.test01.StudentResponse, com.test01.StudentResponse.Builder, com.test01.StudentResponseOrBuilder> studentResponseBuilder_;

    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<com.test01.StudentResponse> getStudentResponseList() {
      if (studentResponseBuilder_ == null) {
        return java.util.Collections.unmodifiableList(studentResponse_);
      } else {
        return studentResponseBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public int getStudentResponseCount() {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.size();
      } else {
        return studentResponseBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public com.test01.StudentResponse getStudentResponse(int index) {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.get(index);
      } else {
        return studentResponseBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder setStudentResponse(
        int index, com.test01.StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.set(index, value);
        onChanged();
      } else {
        studentResponseBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder setStudentResponse(
        int index, com.test01.StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.set(index, builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(com.test01.StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.add(value);
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        int index, com.test01.StudentResponse value) {
      if (studentResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureStudentResponseIsMutable();
        studentResponse_.add(index, value);
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        com.test01.StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.add(builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder addStudentResponse(
        int index, com.test01.StudentResponse.Builder builderForValue) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.add(index, builderForValue.build());
        onChanged();
      } else {
        studentResponseBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder addAllStudentResponse(
        java.lang.Iterable<? extends com.test01.StudentResponse> values) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, studentResponse_);
        onChanged();
      } else {
        studentResponseBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder clearStudentResponse() {
      if (studentResponseBuilder_ == null) {
        studentResponse_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        studentResponseBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public Builder removeStudentResponse(int index) {
      if (studentResponseBuilder_ == null) {
        ensureStudentResponseIsMutable();
        studentResponse_.remove(index);
        onChanged();
      } else {
        studentResponseBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public com.test01.StudentResponse.Builder getStudentResponseBuilder(
        int index) {
      return getStudentResponseFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public com.test01.StudentResponseOrBuilder getStudentResponseOrBuilder(
        int index) {
      if (studentResponseBuilder_ == null) {
        return studentResponse_.get(index);  } else {
        return studentResponseBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<? extends com.test01.StudentResponseOrBuilder> 
         getStudentResponseOrBuilderList() {
      if (studentResponseBuilder_ != null) {
        return studentResponseBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(studentResponse_);
      }
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public com.test01.StudentResponse.Builder addStudentResponseBuilder() {
      return getStudentResponseFieldBuilder().addBuilder(
          com.test01.StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public com.test01.StudentResponse.Builder addStudentResponseBuilder(
        int index) {
      return getStudentResponseFieldBuilder().addBuilder(
          index, com.test01.StudentResponse.getDefaultInstance());
    }
    /**
     * <code>repeated .com.test01.StudentResponse studentResponse = 1;</code>
     */
    public java.util.List<com.test01.StudentResponse.Builder> 
         getStudentResponseBuilderList() {
      return getStudentResponseFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.test01.StudentResponse, com.test01.StudentResponse.Builder, com.test01.StudentResponseOrBuilder> 
        getStudentResponseFieldBuilder() {
      if (studentResponseBuilder_ == null) {
        studentResponseBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.test01.StudentResponse, com.test01.StudentResponse.Builder, com.test01.StudentResponseOrBuilder>(
                studentResponse_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        studentResponse_ = null;
      }
      return studentResponseBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.test01.StudentResponseList)
  }

  // @@protoc_insertion_point(class_scope:com.test01.StudentResponseList)
  private static final com.test01.StudentResponseList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.test01.StudentResponseList();
  }

  public static com.test01.StudentResponseList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StudentResponseList>
      PARSER = new com.google.protobuf.AbstractParser<StudentResponseList>() {
    @java.lang.Override
    public StudentResponseList parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StudentResponseList(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StudentResponseList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StudentResponseList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.test01.StudentResponseList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

